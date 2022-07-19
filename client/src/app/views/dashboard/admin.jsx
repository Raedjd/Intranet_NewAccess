import {Autocomplete, Button, Card, Grid, Icon, styled, TextField, useTheme} from '@mui/material';
import React, {Fragment, useEffect , useState} from 'react';
import Campaigns from './shared/Campaigns';
import DoughnutChart from './shared/Doughnut';
import RowCards from './shared/RowCards';
import StatCards from './shared/StatCards';
import StatCards2 from './shared/StatCards2';
import TopSellingDepartment from './shared/TopSellingDepartment';
import UpgradeCard from './shared/UpgradeCard';
import {Span} from "../../components/Typography";
import axios from "../../../axios";
import {fetchDepartmentData, fetchUserData, getToken} from "../../auth/authRoles";



const ContentBox = styled('div')(({ theme }) => ({
    margin: '30px',
    [theme.breakpoints.down('sm')]: { margin: '16px' },
}));

const Title = styled('span')(() => ({
    fontSize: '1rem',
    fontWeight: '500',
    marginRight: '.5rem',
    textTransform: 'capitalize',
}));

const SubTitle = styled('span')(({ theme }) => ({
    fontSize: '0.875rem',
    color: theme.palette.text.secondary,
}));

const H4 = styled('h4')(({ theme }) => ({
    fontSize: '1rem',
    fontWeight: '500',
    marginBottom: '16px',
    textTransform: 'capitalize',
    color: theme.palette.text.secondary,
}));





const Admin = () => {
    const { palette } = useTheme();


    const [nameDepart,setNameDepart]=useState('');
    const addDepartment = async (e) => {
        e.preventDefault();
        const departSuccess = document.querySelector(".depart");

        await axios({
            method: "post",
            url: `http://localhost:8082/dep/add`,

            data: {
                nameDepart: nameDepart

            },
            headers: {
                'Authorization': 'Bearer ' + getToken()
            }
        }).then((response)=>{
            console.log(response);
            departSuccess.innerHTML =response.data;
        })

    }
    const suggestions = [
        { label: 'Admin' },
        { label: 'RH' },
        { label: 'Enginner' },

    ];

    const [depData,setDepData]=useState({});

    React.useEffect(()=>{
        fetchDepartmentData().then((response)=>{
            setDepData(response.data);
        })
    },[])



    const [username,setUsername]=useState('');
    const [mail, setMail] = useState("");
    const [role, setRole] = useState("");
    const [nameDep, setNameDep] = useState("");
    const [password, setPassword] = useState("");
    const [confPassword, setConfPassword] = useState("");
    const addUser = async (e) => {
        e.preventDefault();
        const userSuccess = document.querySelector(".user");
        await axios({
            method: "post",
            url: `http://localhost:8082/user/add/${nameDep}`,

            data: {
                username:username,
                mail:mail,
                password:password,
                role:role


            },
            headers: {
                'Authorization': 'Bearer ' + getToken()
            }
        }).then((response)=>{
            console.log(response);


        })

    }

    return (
        <Fragment>
            <ContentBox className="analytics">
                <Grid container spacing={3}>
                    <Grid item lg={8} md={8} sm={12} xs={12}>

                        <TopSellingDepartment />

                    </Grid>

                    <Grid item lg={4} md={4} sm={12} xs={12}>
                        <Card sx={{ px: 3, py: 2, mb: 3 }}>
                             <form onSubmit={addDepartment}>
                            <Title>Add department</Title>
                            <Grid item lg={6} md={6} sm={12} xs={12} sx={{ mt: 2 }}>
                                <TextField
                                    type="text"
                                    name="Name"
                                    id="standard-basic"
                                    label="Name of departemnt"
                                    id="nameDepart"
                                    onChange={(e) =>setNameDepart(e.target.value)}
                                    value={nameDepart}

                                />

                            </Grid>
                            <Button color="secondary" variant="contained" type="submit" disabled={!nameDepart}>
                                <Icon>send</Icon>
                                <Span sx={{ pl: 1, textTransform: "capitalize" }}>Submit</Span>
                            </Button>
                                 <div className="depart text-success"></div>
                             </form>

                        </Card>


                        <Card sx={{ px: 3, py: 2, mb: 3 }}>
                            <form onSubmit={addUser}>
                            <Title>Add user</Title>
                            <Grid item lg={6} md={6} sm={12} xs={12} sx={{ mt: 2 }}>
                                <TextField
                                    type="text"
                                    name="username"
                                    label="Username "
                                    id="username"
                                    onChange={(e) => setUsername(e.target.value)}
                                    value={username}

                                />
                                <TextField
                                    type="email"
                                    name="email"
                                    label="Mail "
                                    id="email"
                                    onChange={(e) => setMail(e.target.value)}
                                    value={mail}

                                />
                                <Autocomplete
                                    options={suggestions}
                                    getOptionLabel={(option) => option.label}
                                    onChange={(e , v) => setRole(v.label) }
                                    renderInput={(params) => (
                                        <TextField {...params} label="Role" variant="outlined" fullWidth
                                                     />
                                    ) }
                                />
                                <Autocomplete
                                    options={depData}
                                    getOptionLabel={(option) => option.nameDepart}
                                    onChange={(e , v) => setNameDep(v.nameDepart) }
                                    renderInput={(params) => (
                                        <TextField {...params} label="Assign to department" variant="outlined" fullWidth
                                                />
                                    )}
                                />
                                <TextField
                                    name="password"
                                    type="password"
                                    label="Password"
                                    id="password"
                                    onChange={(e) => setPassword(e.target.value)}
                                    value={password}

                                />
                                <TextField
                                    type="password"
                                    name="confirmPassword"

                                    label="Confirm Password"
                                    id="confpassword"
                                    onChange={(e) => setConfPassword(e.target.value)}
                                    value={confPassword}


                                />
                                <Button color="secondary" variant="contained" type="submit">
                                    <Icon>send</Icon>
                                    <Span sx={{ pl: 1, textTransform: "capitalize" }}>Submit</Span>
                                </Button>
                                <div className="user text-success"></div>
                            </Grid>
                            </form>
                        </Card>

                    </Grid>
                </Grid>
            </ContentBox>
        </Fragment>
    );
};

export default Admin;
