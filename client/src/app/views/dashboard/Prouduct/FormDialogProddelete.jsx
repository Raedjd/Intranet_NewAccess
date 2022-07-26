
import {Box, Fab, Icon} from '@mui/material';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import TextField from '@mui/material/TextField';
import React, {useState} from 'react';
import axios from "../../../../axios";
import {fetchUserData, getToken} from "../../../auth/authRoles";

export default function FormDialogProddelete({idProd, Add}) {
    const [open, setOpen] = React.useState(false);

    function handleClickOpen() {
        setOpen(true);
    }

    function handleClose() {
        setOpen(false);
    }

    const [nameProduct,setNameProduct]=useState('');
    const deleteProduct = async (e) => {
        e.preventDefault();

        await axios({
            method: "delete",
            url: `http://localhost:8082/product/delete/${idProd}`,

            data: {
                nameProduct: nameProduct

            },
            headers: {
                'Authorization': 'Bearer ' + getToken()
            }
        }).then((response)=>{
            window.location.reload();
        })

    }

    const [yes,setYes]=useState(false);
    React.useEffect(()=>{
        fetchUserData().then((response)=>{
            setYes(response.data.id==Add);


        })
    },[])

    console.log(yes)

    return (
        <Box>
            <Fab variant="outlined" aria-label="Delete" className="button" onClick={handleClickOpen} disabled={!yes}>
                <Icon>delete</Icon>

            </Fab>

            <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">Are sure?</DialogTitle>

                <DialogActions>
                    <Button variant="outlined" color="secondary" onClick={handleClose}>
                        Cancel
                    </Button>
                    <Button onClick={deleteProduct}   color="primary" >
                        Delete
                    </Button>

                </DialogActions>

            </Dialog>
        </Box>
    );
}
