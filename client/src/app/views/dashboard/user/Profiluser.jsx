import {Grid, Stack} from "@mui/material";
import { Box, styled } from "@mui/system";
import { Breadcrumb, SimpleCard } from "app/components";
import Settings from "./settings";
import Setting from "./setting";



const Container = styled("div")(({ theme }) => ({
    margin: "30px",
    [theme.breakpoints.down("sm")]: { margin: "16px" },
    "& .breadcrumb": {
        marginBottom: "30px",
        [theme.breakpoints.down("sm")]: { marginBottom: "16px" },
    },
}));
const ContentBox = styled('div')(({ theme }) => ({
    margin: '30px',
    [theme.breakpoints.down('sm')]: { margin: '16px' },
}));

const Profiluser = () => {
    return (
        <Container>
            <Box className="breadcrumb">
                <Breadcrumb routeSegments={[{ name: "Upadate", path: "/profil" }, { name: "Profil" }]} />
            </Box>

                <ContentBox className="analytics">
                    <Grid container spacing={3}>
                        <Grid item lg={12} md={8} sm={10} xs={12}>
                            <SimpleCard title="Profil">

                            </SimpleCard>

                        </Grid>
                        <Grid item lg={6} md={5} sm={10} xs={12}>
                            <SimpleCard title="Settings">
                                <Settings />
                            </SimpleCard>

                        </Grid>
                        <Grid item lg={6} md={8} sm={10} xs={12}>
                            <SimpleCard >
                                <Setting />
                            </SimpleCard>

                        </Grid>
                    </Grid>
                </ContentBox>



        </Container>
    );
};


export default Profiluser;
