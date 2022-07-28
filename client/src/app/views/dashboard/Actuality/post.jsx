import {
    Avatar,
    Badge,
    Button,
    Card, Fab,
    Grid,
    Hidden, Icon,
    Stack,
    Table,
    TableCell,
    TableHead,
    TableRow, TextareaAutosize,
    useTheme
} from "@mui/material";
import {Box, styled} from "@mui/system";
import {Breadcrumb, SimpleCard} from "app/components";

import {fetchUserData} from "../../../auth/authRoles";
import  React ,{useState} from "react";
import TextField from "@mui/material/TextField";
import {Span} from "../../../components/Typography";


const PostUser = () => {

    return (


                <Grid container spacing={3}>

                    <Grid item lg={12} md={12} sm={10} xs={12}>


                        <Card sx={{ px: 20, py: 6, mb: 6,  bgcolor:"#F5F5F5" }}>
                            <div>
                            <TextareaAutosize
                                aria-label="minimum height"
                                minRows={3}
                                placeholder="Minimum 3 rows"
                                style={{ width: 1000 , height:80}}
                            />

                            </div>
                            <Fab variant="extended" aria-label="Delete" type="file"  style={{ width:150 , height:50 , mb:50}} className="button"  >
                                Cancel
                            </Fab>
                            <Fab variant="extended" aria-label="Delete"  style={{ width:150 , height:50 , mb:50}} className="button"  >
                                Send
                            </Fab>

                        </Card>

                    </Grid>

                </Grid>

    );
};


export default PostUser;
