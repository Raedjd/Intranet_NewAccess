import { LoadingButton } from '@mui/lab';
import { Card, Grid, TextField } from '@mui/material';
import { Box, styled, useTheme } from '@mui/system';
import { Paragraph } from 'app/components/Typography';
import { Formik } from 'formik';
import { useState } from 'react';
import {Navigate, NavLink, useNavigate} from 'react-router-dom';

import axios from "axios";
import cookie from "js-cookie";
const FlexBox = styled(Box)(() => ({ display: 'flex', alignItems: 'center' }));

const JustifyBox = styled(FlexBox)(() => ({ justifyContent: 'center' }));

const ContentBox = styled(Box)(() => ({
  height: '100%',
  padding: '32px',
  position: 'relative',
  background: 'rgba(0, 0, 0, 0.01)',
}));

const JWTRoot = styled(JustifyBox)(() => ({
  background: '#1A2038',
  minHeight: '100% !important',
  '& .card': {
    maxWidth: 800,
    minHeight: 400,
    margin: '1rem',
    display: 'flex',
    borderRadius: 12,
    alignItems: 'center',
  },
}));





const JwtLogin = () => {
  const theme = useTheme();
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const handleLogin = async (e) => {
    e.preventDefault();


    await axios({
      method: "post",
      url: `http://localhost:8080/auth/login`,

      data: {
        username: username,
        password: password,
      },
    })
        .then((response) => {
          console.log(response);
       cookie.set("jwt", response.data.token);
      navigate("/dashboard");
        })
  }

  let token =cookie.get("jwt");
  return !token ? (
    <JWTRoot>
      <Card className="card">
        <Grid container>
          <Grid item sm={6} xs={12}>
            <JustifyBox p={4} height="100%" sx={{ minWidth: 320 }}>
              <img src="/src/illustrations/newaccess.jfif" width="100%"  />
            </JustifyBox>
          </Grid>

          <Grid item sm={6} xs={12}>
            <ContentBox>
              <Formik>
                {({ values, errors, touched, handleChange, handleBlur, handleSubmit }) => (
                  <form onSubmit={handleLogin}>
                    <TextField
                      fullWidth
                      size="small"
                      type="username"
                      name="username"
                      label="Username"
                      variant="outlined"
                      onBlur={handleBlur}
                      id="username"
                      onChange={(e) => setUsername(e.target.value)}
                      value={username}
                      aria-describedby="inputGroupPrepend"
                      required
                      sx={{ mb: 3 }}
                    />

                    <TextField
                      fullWidth
                      size="small"
                      name="password"
                      type="password"
                      label="Password"
                      variant="outlined"
                      onBlur={handleBlur}
                      id="password"
                      onChange={(e) => setPassword(e.target.value)}
                      value={password}
                      aria-describedby="inputGroupPrepend"
                      required
                      sx={{ mb: 1.5 }}
                    />




                    <LoadingButton
                      type="submit"
                      color="secondary"
                      loading={loading}
                      variant="contained"
                      sx={{ my: 2 }}
                      sx={{ mx: 15 }}

                    >
                      Login
                    </LoadingButton>

                    <Paragraph>
                      Don't have an account?
                      <NavLink
                        to="/session/signup"
                        style={{ color: theme.palette.primary.main, marginLeft: 5 }}
                      >
                        Register
                      </NavLink>
                    </Paragraph>
                  </form>
                )}
              </Formik>
            </ContentBox>
          </Grid>
        </Grid>
      </Card>
    </JWTRoot>
  ):(
      <Navigate to="*"/>
  );
};

export default JwtLogin;
