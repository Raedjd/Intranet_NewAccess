import {Autocomplete, DatePicker} from "@mui/lab";
import Box from '@mui/material/Box';
import AdapterDateFns from "@mui/lab/AdapterDateFns";
import LocalizationProvider from "@mui/lab/LocalizationProvider";
import {
    Button,
    Checkbox,
    FormControlLabel,
    Grid,
    Icon,
    Radio,
    RadioGroup,
    styled,
} from "@mui/material";
import { Span } from "app/components/Typography";
import React, { useEffect, useState } from "react";
import { TextValidator, ValidatorForm } from "react-material-ui-form-validator";
import axios from "../../../../axios";
import {fetchUserData, getToken} from "../../../auth/authRoles";




const TextField = styled(TextValidator)(() => ({
    width: "100%",
    marginBottom: "16px",
}));

const Setting = () => {

/////////////////////////////////////////////////////////////////////////////////////:
    const [userData,setUserData]=useState({});

    React.useEffect(()=>{
        fetchUserData().then((response)=>{
            setUserData(response.data);
        })
    },[])

    const id=userData.id;
    const [state, setState] = useState({ date: new Date() });

    useEffect(() => {
        ValidatorForm.addValidationRule("isPasswordMatch", (value) => {
            if (value !== state.password) return false;

            return true;
        });
        return () => ValidatorForm.removeValidationRule("isPasswordMatch");
    }, [state.password]);

    const handleSubmit = (event) => {
        // console.log("submitted");
        // console.log(event);
    };

    const handleChange = (event) => {
        event.persist();
        setState({ ...state, [event.target.name]: event.target.value });
    };

    const handleDateChange = (date) => setState({ ...state, date });

    const {
        username,
        firstName,
        creditCard,
        mobile,
        password,
        confirmPassword,
        gender,
        date,
        email,
    } = state;


    const [image, setImage] = useState("");

    const handleUpdatePDP = async (e) => {
        e.preventDefault();
        if (!image) return console.log("No files were uploaded.");

        if (!image.size > 1024 * 1024) console.log("Size too large.");

        let data = new FormData();
        data.append("multipartFile", image);
       await axios({
            method: "patch",
            url: `http://localhost:8082/cloudinary/upload/${id}`,
            data,
            headers: { "content-type": "multipartFile/form-data",
           'Authorization': 'Bearer ' + getToken()},

        })
            .then((res) => {
                 console.log(res.data);

            })
    };

    return (

        <div>
            <form onSubmit={handleUpdatePDP} >
                <Grid container spacing={6}>
                    <Grid item lg={6} md={6} sm={12} xs={12} sx={{ mt: 2 }}>


                        <input
                            name="avatar"
                            type="file"
                            accept=".jpg, .jpeg, .png"
                            onChange={(e) => setImage(e.target.files[0])}


                        />


                    </Grid>
                </Grid>
                <p>Image size should be under 1024MB .</p>

                <Button color="primary" variant="contained" type="submit">
                    <Icon>send</Icon>
                    <Span sx={{ pl: 1, textTransform: "capitalize" }}>Change avatar</Span>
                </Button>
            </form>
          {/*  <ValidatorForm  onError={() => null}>
                <Grid container spacing={6}>
                    <Grid item lg={6} md={6} sm={12} xs={12} sx={{ mt: 2 }}>
                        <TextField
                            name="password"
                            type="password"
                            label="Old password"
                            value={password || ""}
                            onChange={handleChange}
                            validators={["required"]}
                            errorMessages={["this field is required"]}
                        />


                        <TextField
                            name="password"
                            type="password"
                            label="New password"
                            value={password || ""}
                            onChange={handleChange}
                            validators={["required"]}
                            errorMessages={["this field is required"]}
                        />
                        <TextField
                            type="password"
                            name="confirmPassword"
                            onChange={handleChange}
                            label="Confirm Password"
                            value={confirmPassword || ""}
                            validators={["required", "isPasswordMatch"]}
                            errorMessages={["this field is required", "password didn't match"]}
                        />

                    </Grid>
                </Grid>

                <Button color="primary" variant="contained" type="submit">
                    <Icon>send</Icon>
                    <Span sx={{ pl: 1, textTransform: "capitalize" }}>Change password</Span>
                </Button>
            </ValidatorForm>*/}

        </div>

    );
};



export default Setting;
