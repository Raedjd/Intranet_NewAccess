
import JwtLogin from "./JwtLogin";
import NotFound from "./NotFound";

const sessionRoutes = [
  { path: '/login', element: <JwtLogin /> },
  { path: '*', element: <NotFound /> },
];

export default sessionRoutes;
