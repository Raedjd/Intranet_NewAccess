import {
    Box,
    Card, Fab, Icon,
    styled,
    Table,
    TableBody,
    TableCell,
    TableHead, TablePagination,
    TableRow,

} from '@mui/material';

import React, {useState} from "react";
import {fetchEventsData, fetchUserData,} from "../../../auth/authRoles";
import Rating from '@mui/material/Rating';
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import EventbyUser from "./SimpleDialogUserevent";
import EventByparticipant from "./EventByparticipant";

const CardHeader = styled(Box)(() => ({
    display: 'flex',
    paddingLeft: '24px',
    paddingRight: '24px',
    marginBottom: '12px',
    alignItems: 'center',
    justifyContent: 'space-between',
}));

const Title = styled('span')(() => ({
    fontSize: '1rem',
    fontWeight: '500',
    textTransform: 'capitalize',
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

const StyledRating = styled(Rating)({
    '& .MuiRating-iconFilled': {
        color: '#ff6d75',
    },
    '& .MuiRating-iconHover': {
        color: '#ff3d47',
    },
});

const Eventlistdone= ({iduser}) =>{
    const [page, setPage] = useState(0);
    const [rowsPerPage, setRowsPerPage] = useState(5);


    const handleChangePage = (_, newPage) => {
        setPage(newPage);
    };
    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(+event.target.value);
        setPage(0);
    };
    const [EventsData,setEventsData]=useState({});
    React.useEffect(()=>{
        fetchEventsData().then((response)=>{
            setEventsData(response.data);

        })
    },[])
    const events = Object.keys(EventsData).map((key) => EventsData[key]);

   const eventsDatadone=events.filter((e)=>e.done===true)
    const [rate,setRate]=useState(0);
console.log(rate)
    return (
        <Card elevation={3} sx={{ pt: '20px', mb: 3 }}>
            <CardHeader>
                <Title>All Events</Title>

            </CardHeader>

            <Box width="100%" overflow="auto">

                <StyledTable>

                    <TableHead>
                        <TableRow>
                            <TableCell align="center">Number</TableCell>
                            <TableCell align="center">Title</TableCell>
                            <TableCell align="center">Rating</TableCell>
                            <TableCell align="center">The participants</TableCell>

                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {eventsDatadone
                            .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                            .map((e, index) => (
                                <TableRow key={index}>
                                    <TableCell align="center">   <Fab variant="extended" aria-label="Delete" className="button"  >{index+1}   </Fab></TableCell>
                                    <TableCell align="center">{e.title}</TableCell>
                                    <TableCell align="center">
                                        <StyledRating
                                        name="customized-color"
                                        defaultValue={0}
                                        getLabelText={(value: number) => `${value} Heart${value !== 1 ? 's' : ''}`}
                                        precision={0.5}
                                        icon={<FavoriteIcon fontSize="inherit" />}
                                        emptyIcon={<FavoriteBorderIcon fontSize="inherit" />}
                                        onClick={(e) =>setRate(e.target.value)}
                                    /></TableCell>
                                    <TableCell align="center" ><EventByparticipant key={index}  idEvent={e.id}></EventByparticipant></TableCell>

                                </TableRow>
                            ))}
                    </TableBody>
                </StyledTable>

                <TablePagination
                    sx={{ px: 2 }}
                    page={page}
                    component="div"
                    rowsPerPage={rowsPerPage}
                    count={events.length}
                    onPageChange={handleChangePage}
                    rowsPerPageOptions={[5, 10, 25]}
                    onRowsPerPageChange={handleChangeRowsPerPage}
                    nextIconButtonProps={{ "aria-label": "Next Page" }}
                    backIconButtonProps={{ "aria-label": "Previous Page" }}
                />
            </Box>
        </Card>

    );
}
export default Eventlistdone;