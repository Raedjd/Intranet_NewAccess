import {
    Card, CardActions,
    CardContent, CardHeader, CardMedia,
    Grid,

} from "@mui/material";
import {styled} from "@mui/system";
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import { fetchPostsData} from "../../../auth/RoutsData";
import  React ,{useState} from "react";
import IconButton from "@mui/material/IconButton";
import Typography from "@mui/material/Typography";
import {IconButtonProps} from "@mui/material";


import UserPostAvatarData from "./UserPostData/userPostAvatarData";
import UserPostNameData from "./UserPostData/userPostNameData";
import {dateParser} from "../utilis";
import UserPostEdit from "./UserPostData/userPostEdit";
import UserPostDelete from "./UserPostData/userPostDelete";
import LikePost from "./UserPostData/likePost";
import ShowLike from "./UserPostData/showLike";

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
export default function  PostCard ({userAdd}){


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

                    <Grid item lg={4} md={6} sm={10} xs={14} sx={{ bgcolor:"#fafafa"  }} key={index}  >


                            <Card sx={{ maxWidth: 345 }}>
                                <CardHeader
                                    avatar={
                                  <UserPostAvatarData  userAdd={p.userid}></UserPostAvatarData>
                                    }
                                    action={
                                        <IconButton aria-label="settings">
                                            <MoreVertIcon />
                                        </IconButton>
                                    }
                                    title={<UserPostNameData  userAdd={p.userid}></UserPostNameData>}
                                    subheader={dateParser(p.dateCreation)}
                                />
                                <CardMedia
                                    component="img"
                                    height="194"
                                    image={p.image.imageUrl}
                                />
                                <CardContent>
                                    <Typography variant="body2" color="text.secondary">
                                        {p.description}
                                    </Typography>
                                </CardContent>
                                <CardActions disableSpacing>

                                    <LikePost  userAdd={p.userid} idPost={p.id} ></LikePost>
                                    <ShowLike idPost={p.id} ></ShowLike>
                                    <UserPostEdit  userAdd={p.userid} idPost={p.id} ></UserPostEdit>
                                    <UserPostDelete userAdd={p.userid} idPost={p.id}></UserPostDelete>

                                    <ExpandMore
                                        expand={expanded}
                                        onClick={handleExpandClick}
                                        aria-expanded={expanded}
                                        aria-label="show more"
                                    >
                                        <ExpandMoreIcon />
                                    </ExpandMore>

                                </CardActions>
                            </Card>

                    </Grid>

                    ))}
                </Grid>
            </ContentBox>


        </Container>
    );
};