import {Box, Icon, IconButton, styled, Table, TableBody, TableCell, TableHead, TableRow} from "@mui/material";
import { Breadcrumb, SimpleCard } from "app/components";
import SimpleTable from "../../material-kit/tables/SimpleTable";


const Container = styled("div")(({ theme }) => ({
    margin: "30px",
    [theme.breakpoints.down("sm")]: { margin: "16px" },
    "& .breadcrumb": {
        marginBottom: "30px",
        [theme.breakpoints.down("sm")]: { marginBottom: "16px" },
    },
}));

const StyledTable = styled(Table)(({ theme }) => ({
    whiteSpace: "pre",
    "& thead": {
        "& tr": { "& th": { paddingLeft: 0, paddingRight: 0 } },
    },
    "& tbody": {
        "& tr": { "& td": { paddingLeft: 0, textTransform: "capitalize" } },
    },
}));




const Listevent = () => {
    return (
        <Container>
            <Box className="breadcrumb">
                <Breadcrumb routeSegments={[{ name: "List", path: "/events" }, { name: "Events" }]} />
            </Box>

            <SimpleCard title="Simple Table">
                <Box width="100%" overflow="auto">
                    <StyledTable>
                        <TableHead>
                            <TableRow>
                                <TableCell align="left">Title</TableCell>
                                <TableCell align="center">Description</TableCell>
                                <TableCell align="center">Start Date</TableCell>
                                <TableCell align="center">End date</TableCell>
                                <TableCell align="center">Update</TableCell>
                                <TableCell align="right">Delete</TableCell>
                            </TableRow>
                        </TableHead>

                        <TableBody>

                            <TableRow >
                                <TableCell align="left"></TableCell>


                            </TableRow>

                        </TableBody>
                    </StyledTable>
                </Box>
            </SimpleCard>


        </Container>
    );
};

export default Listevent;
