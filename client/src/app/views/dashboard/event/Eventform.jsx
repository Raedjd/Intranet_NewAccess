import { DatePicker } from "@mui/lab";
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
import { useEffect, useState } from "react";
import { TextValidator, ValidatorForm } from "react-material-ui-form-validator";
import {FileDownloadDone, FileUpload} from "@mui/icons-material";

const TextField = styled(TextValidator)(() => ({
    width: "100%",
    marginBottom: "16px",
}));

const Eventform = () => {
    const [state, setState] = useState({ date: new Date() });

    useEffect(() => {
        ValidatorForm.addValidationRule("isPasswordMatch", (value) => {
            if (value !== state.password) return false;

            return true;
        });
        return () => ValidatorForm.removeValidationRule("isPasswordMatch");
    }, [state.password]);





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

    return (
        <div>
            <ValidatorForm  onError={() => null}>

                <Grid item lg={6} md={6} sm={12} xs={12} sx={{ mt: 2 }}>
                    <TextField
                        type="text"
                        name="Title"
                        label="Title"
                        id="standard-basic"

                        errorMessages={["this field is required"]}

                        validators={["required", "minStringLength: 4", "maxStringLength: 9"]}

                    />

                    <TextField
                        type="text"
                        name="Description"
                        label="Description"

                        validators={["required"]}
                        errorMessages={["this field is required"]}
                    />
                    <TextField
                        type="datetime-local"
                        name="date"
                        label="Start date"


                        validators={["required"]}
                        errorMessages={["this field is required"]}
                    />
                    <TextField
                        type="datetime-local"
                        name="date"
                        label="End date"

                        validators={["required"]}
                        errorMessages={["this field is required"]}
                    />

                </Grid>




                <Button color="secondary" variant="contained" type="submit">
                    <Icon>send</Icon>
                    <Span sx={{ pl: 1, textTransform: "capitalize" }}>Add event</Span>
                </Button>
            </ValidatorForm>




        </div>
    );
};

export default Eventform;
