import FavoriteIcon from "@mui/icons-material/Favorite";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import React, {useState} from "react";
import {styled} from "@mui/material";
import Rating from "@mui/material/Rating";
import {fetchUserData, getToken} from "../../../../auth/RoutsData";
import axios from "axios";
import IconButton from "@mui/material/IconButton";


const StyledRating = styled(Rating)({
    '& .MuiRating-iconFilled': {
        color: '#ff6d75',
    },
    '& .MuiRating-iconHover': {
        color: '#ff3d47',
    },
});

export default function LikePost({idPost}) {



    const [userData,setUserData]=useState({});
    React.useEffect(()=>{
        fetchUserData().then((response)=>{
            setUserData(response.data);


        })
    },[])

    return(

            <IconButton aria-label="add to favorites"
                        onClick={(e) => {
                            axios({
                                method: "post",
                                url: `http://localhost:8082/love/add/${userData.id}/${idPost}`,
                                data: {
                                    nbrLike:-1


                                },
                                headers: {
                                    'Authorization': 'Bearer ' + getToken()
                                }

                            })
                            window.location.reload();
                        }}>
                <FavoriteIcon />
            </IconButton>

    )
}