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





export default function Participation({idEvent, userId}) {

    const participationEvent = async (e) => {
        e.preventDefault();
        await axios({
            method: "patch",
            url: `http://localhost:8082/event/participation/${userId}/${idEvent}`,
            headers: {
                'Authorization': 'Bearer ' + getToken()
            }
        }).then((response)=>{
        })

    }
    const [idData,setIdData]=useState({});
    React.useEffect(()=>{
        fetchEventsData().then((response)=>{
            setIdData(response.data.map((e)=>e.users.map((i)=>i.id)));


        })
    },[])

    const [userData,setUserData]=useState("");

    React.useEffect(()=>{
        fetchUserData().then((response)=>{
            setUserData(response.data.id);


        })
    },[])
    const ids= Object.keys(idData).map((key) => idData[key]);




    const [participantsData,setParticapantsData]=useState({});
    React.useEffect(()=>{
        axios({
            method: 'GET',
            url: `http://localhost:8082/event/findOne/${idEvent}`,
            headers: {
                'Authorization': 'Bearer ' + getToken()
            }
        }).then((response)=>{
            setParticapantsData(response.data.users);


        })
    },[])
    const participants = Object.keys(participantsData).map((key) => participantsData[key]);
 const part= participants.map((i)=>i.id)

    return (
        <Fab color="primary" aria-label="Add" className="button" onClick={participationEvent} disabled={part.includes(userId)}  >
            <Icon>add</Icon>
        </Fab>
    );
}