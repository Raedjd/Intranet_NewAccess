import {
    Avatar,
    Badge,
    Card, CardActions,
    CardContent, CardHeader, CardMedia, Collapse,
    Grid,
    Hidden,
    Stack,
    Table,
    TableCell,
    TableHead,
    TableRow,
    useTheme
} from "@mui/material";
import {Box, styled} from "@mui/system";
import {Breadcrumb, SimpleCard} from "app/components";
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';

import {fetchEventsData, fetchPostsData, fetchUserData, getToken} from "../../../auth/authRoles";
import  React ,{useState} from "react";
import IconButton from "@mui/material/IconButton";
import Typography from "@mui/material/Typography";
import {red} from "@mui/material/colors";
import {IconButtonProps} from "@mui/material";
import FavoriteIcon from '@mui/icons-material/Favorite';
import axios from "../../../../axios";
import UserPostData from "./userPostData";




const Container = styled("div")(({theme}) => ({
    margin: "30px",
    [theme.breakpoints.down("sm")]: {margin: "16px"},
    "& .breadcrumb": {
        marginBottom: "30px",
        [theme.breakpoints.down("sm")]: {marginBottom: "16px"},
    },
}));
const ContentBox = styled('div')(({theme}) => ({
    margin: '30px',
    [theme.breakpoints.down('sm')]: {margin: '16px'},
}));

interface ExpandMoreProps extends IconButtonProps {
    expand: boolean;
}

const ExpandMore = styled((props: ExpandMoreProps) => {
    const { expand, ...other } = props;
    return <IconButton {...other} />;
})(({ theme, expand }) => ({
    transform: !expand ? 'rotate(0deg)' : 'rotate(180deg)',
    marginLeft: 'auto',
    transition: theme.transitions.create('transform', {
        duration: theme.transitions.duration.shortest,
    }),
}));
export default function  PostCard (){


    const [postsData,setPostsData]=useState({});
    React.useEffect(()=>{
        fetchPostsData().then((response)=>{
            setPostsData(response.data);

        })
    },[])
    const posts = Object.keys(postsData).map((key) => postsData[key]);


    const [expanded, setExpanded] = React.useState(false);

    const handleExpandClick = () => {
        setExpanded(!expanded);
    };


    return (
        <Container>
            <ContentBox className="analytics">
                <Grid container spacing={3}>
                    {posts.map((p, index) => (
                    <Grid item lg={3} md={6} sm={10} xs={14} sx={{ bgcolor:"#e6e6e6"  }}   >


                            <Card sx={{ maxWidth: 345 }}>
                                <CardHeader
                                    avatar={
                                  <UserPostData key={index} userAdd={p.userid}></UserPostData>
                                    }
                                    action={
                                        <IconButton aria-label="settings">
                                            <MoreVertIcon />
                                        </IconButton>
                                    }
                                    title="Shrimp and Chorizo Paella"
                                    subheader="September 14, 2016"
                                />
                                <CardMedia
                                    component="img"
                                    height="194"
                                    image="/static/images/cards/paella.jpg"
                                    alt="Paella dish"
                                />
                                <CardContent>
                                    <Typography variant="body2" color="text.secondary">
                                        This impressive paella is a perfect party dish and a fun meal to cook
                                        together with your guests. Add 1 cup of frozen peas along with the mussels,
                                        if you like.
                                    </Typography>
                                </CardContent>
                                <CardActions disableSpacing>
                                    <IconButton aria-label="add to favorites">
                                        <FavoriteIcon />
                                    </IconButton>
                                    <IconButton aria-label="share">
                                        <ShareIcon />
                                    </IconButton>
                                </CardActions>
                            </Card>

                    </Grid>
                    ))}
                </Grid>
            </ContentBox>


        </Container>
    );
};