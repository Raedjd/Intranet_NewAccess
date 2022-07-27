import FormControlLabel from "@mui/material/FormControlLabel";
import FormGroup from "@mui/material/FormGroup";
import Stack from "@mui/material/Stack";
import { styled } from "@mui/material/styles";
import Switch from "@mui/material/Switch";
import Typography from "@mui/material/Typography";
import axios from "../../../../axios";
import {fetchEventsData, fetchUserData, getToken} from "../../../auth/authRoles";
import {Icon,  Fab} from "@mui/material";
import {useState} from "react";
import React from "react";
import {boolean} from "yup";



const Android12Switch = styled(Switch)(({ theme }) => ({
    padding: 8,
    "& .MuiSwitch-track": {
        borderRadius: 22 / 2,
        "&:before, &:after": {
            content: '""',
            position: "absolute",
            top: "50%",
            transform: "translateY(-50%)",
            width: 16,
            height: 16,
        },
        "&:before": {
            backgroundImage: `url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" height="16" width="16" viewBox="0 0 24 24"><path fill="${encodeURIComponent(
                theme.palette.getContrastText(theme.palette.primary.main)
            )}" d="M21,7L9,19L3.5,13.5L4.91,12.09L9,16.17L19.59,5.59L21,7Z"/></svg>')`,
            left: 12,
        },
        "&:after": {
            backgroundImage: `url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" height="16" width="16" viewBox="0 0 24 24"><path fill="${encodeURIComponent(
                theme.palette.getContrastText(theme.palette.primary.main)
            )}" d="M19,13H5V11H19V13Z" /></svg>')`,
            right: 12,
        },
    },
    "& .MuiSwitch-thumb": {
        boxShadow: "none",
        width: 16,
        height: 16,
        margin: 2,
    },
}));





export default function DoneEvent({idEvent, Add}) {

    const updateEventdone = async (e) => {
        e.preventDefault();

        await axios({
            method: "put",
            url: `http://localhost:8082/event/done/${idEvent}`,

            data: {
              done:true

            },
            headers: {
                'Authorization': 'Bearer ' + getToken()
            }
        }).then((response)=>{
            console.log(response.data)

        })

    }

    const [event,setEvent]=useState({});
    React.useEffect( async()=>{
        await axios({
            method: "get",
            url: `http://localhost:8082/event/findOne/${idEvent}`,

            data: {
                done:true

            },
            headers: {
                'Authorization': 'Bearer ' + getToken()
            }
        }).then((response)=>{
           setEvent(response.data)


        })
    },[])


    const [yes,setYes]=useState(false);
    React.useEffect(()=>{
        fetchUserData().then((response)=>{
            setYes(response.data.id==Add)


        })
    },[])

    return (
        <Fab color="primary" aria-label="Add" className="button" onClick={updateEventdone} disabled={!yes || event.done}  >
            <Icon>check</Icon>
        </Fab>
    );
}