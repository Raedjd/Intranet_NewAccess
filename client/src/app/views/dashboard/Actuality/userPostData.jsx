
import {Box, Fab, styled, Table, TableBody, TableCell, TableHead, TableRow} from '@mui/material';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import ListItemAvatar from '@mui/material/ListItemAvatar';
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


export default function UserPostData({userAdd}) {
console.log(userAdd)

    const [userAction,setUserAction]=useState({});
    const [userImageAction,setUserImageAction]=useState("");
    React.useEffect(()=>{
        axios({
            method: 'GET',
            url: `http://localhost:8082/user/findOne/${userAdd}`,
            headers: {
                'Authorization': 'Bearer ' + getToken()
            }
        }).then((response)=>{
            setUserAction(response.data);
            setUserImageAction(response.data.image.imageUrl)

        })
    },[])


        return (
            <Avatar src={userImageAction} >
            </Avatar>
        );
    }





