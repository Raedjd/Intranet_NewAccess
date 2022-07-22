
import {Box, Fab, styled, Table, TableBody, TableCell, TableHead, TableRow} from '@mui/material';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import { blue } from '@mui/material/colors';
import Dialog from '@mui/material/Dialog';
import DialogTitle from '@mui/material/DialogTitle';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import ListItemText from '@mui/material/ListItemText';
import Typography from '@mui/material/Typography';
import PropTypes from 'prop-types';
import React, { useState } from 'react';
import axios from "axios";
import {getToken} from "../../../auth/authRoles";


const StyledTable = styled(Table)(() => ({
    whiteSpace: "pre",
    "& thead": {
        "& tr": { "& th": { paddingLeft: 0, paddingRight: 0 } },
    },
    "& tbody": {
        "& tr": { "& td": { paddingLeft: 0, textTransform: "capitalize" } },
    },
}));
const StyledButton = styled(Button)(({ theme }) => ({
    margin: theme.spacing(1),
}));

export default function Users({user}) {

    function SimpleDialog(props) {
        const { onClose, selectedValue, ...other } = props;

        function handleClose() {
            onClose(selectedValue);
        }
        function handleListItemClick(value) {
            onClose(value);
        }




        return (
            <Dialog onClose={handleClose} aria-labelledby="simple-dialog-title" {...other}>


                <Box width="100%" overflow="auto">

                    <StyledTable>

                        <TableHead>
                            <TableRow>
                                <TableCell align="left">Avatar</TableCell>
                                <TableCell align="center">First Name</TableCell>
                                <TableCell align="center">Last Name</TableCell>
                                <TableCell align="center">Role</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {users
                                .map((u, index) => (
                                    <TableRow key={index}>
                                        <TableCell align="center"><ListItemAvatar>
                                            <Avatar sx={{ backgroundColor: blue[100], color: blue[600] }}>
                                                {u.image}
                                            </Avatar>
                                        </ListItemAvatar></TableCell>
                                        <TableCell align="center">{u.firstName}</TableCell>
                                        <TableCell align="center">{u.lastName}</TableCell>
                                        <TableCell align="center">{u.role}</TableCell>

                                    </TableRow>
                                ))}
                        </TableBody>
                    </StyledTable>


                </Box>

            </Dialog>
        );
    }

    SimpleDialog.propTypes = {
        open: PropTypes.bool,
        onClose: PropTypes.func,
        selectedValue: PropTypes.string,
    };


    const [open, setOpen] = useState(false);
    const [selectedValue, setSelectedValue] = useState('user02@gmail.com');

    const handleClickOpen = () => setOpen(true);

    const handleClose = (value) => {
        setOpen(false);
        setSelectedValue(value);
    };

    const fetchUserByDep=(authRequest)=> {
        return axios({
            method: 'GET',
            url: `http://localhost:8082/user/userbydepart/${user}`,
            headers: {
                'Authorization': 'Bearer ' + getToken()
            }
        })
    }
    const [userData,setUserData]=useState({});

    React.useEffect(()=>{
        fetchUserByDep().then((response)=>{
            setUserData(response.data);
        })
    },[])
    const users = Object.keys(userData).map((key) => userData[key]);
    return (
        <Box>

            <Fab variant="extended" aria-label="Delete" className="button"  onClick={handleClickOpen}>
                users
            </Fab>
            <SimpleDialog selectedValue={selectedValue} open={open} onClose={handleClose}/>
        </Box>
    );
}

