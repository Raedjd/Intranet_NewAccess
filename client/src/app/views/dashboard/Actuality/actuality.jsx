import { Stack } from "@mui/material";
import { Box, styled } from "@mui/system";
import { Breadcrumb, SimpleCard } from "app/components";
import PostUser from "./post";



const Container = styled("div")(({ theme }) => ({
    margin: "30px",
    [theme.breakpoints.down("sm")]: { margin: "16px" },
    "& .breadcrumb": {
        marginBottom: "30px",
        [theme.breakpoints.down("sm")]: { marginBottom: "16px" },
    },
}));

const AppForm = () => {
    return (
        <Container>
            <Box className="breadcrumb">
                <Breadcrumb routeSegments={[{ name: "Actuality", path: "/post" }, { name: "Post" }]} />
            </Box>

            <Stack spacing={3}>
                <SimpleCard title="Write post">
                <PostUser></PostUser>
                </SimpleCard>

                <SimpleCard title="All posts">

                </SimpleCard>
            </Stack>
        </Container>
    );
};

export default AppForm;
