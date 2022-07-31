
import React, { useState } from 'react';
import axios from "axios";
import {getToken} from "../../../../auth/RoutsData";

export default function UserPostNameData({userAdd}) {
    const [userAction,setUserAction]=useState({});

    React.useEffect(()=>{
        axios({
            method: 'GET',
            url: `http://localhost:8082/user/findOne/${userAdd}`,
            headers: {
                'Authorization': 'Bearer ' + getToken()
            }
        }).then((response)=>{
            setUserAction(response.data);

        })
    },[])


    return (
        <div>
      {userAction.firstName} {userAction.lastName}
            <br/>
        </div>
    );
}





