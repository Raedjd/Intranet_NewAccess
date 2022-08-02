
import axios from "../../../../axios";
import {fetchUserData, getToken} from "../../../auth/RoutsData";
import {Icon,  Fab} from "@mui/material";
import {useState} from "react";
import React from "react";

export default function DoneEvent({idEvent, Add}) {
    const [isTrue,setIstrue]=useState(false)
    const updateEventdone = async (e) => {
        e.preventDefault();

        await axios({
            method: "put",
            url: `http://localhost:8080/event/done/${idEvent}`,

            data: {
              done:true

            },
            headers: {
                'Authorization': 'Bearer ' + getToken()
            }
        }).then((response)=>{
            setIstrue(true)

        })

    }

    const [event,setEvent]=useState({});
    React.useEffect( async()=>{
        await axios({
            method: "get",
            url: `http://localhost:8080/event/findOne/${idEvent}`,

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
        <Fab color="primary" aria-label="Add" className="button" onClick={updateEventdone} disabled={isTrue || !yes || event.done}  >
            <Icon>check</Icon>
        </Fab>
    );
}