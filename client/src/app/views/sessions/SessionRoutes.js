import Loadable from 'app/components/Loadable';
import { lazy } from 'react';
const JwtLogin = Loadable(lazy(() => import('./JwtLogin')));
const NotFound = Loadable(lazy(() => import('./NotFound')));
const sessionRoutes = [
  { path: '/login', element: <JwtLogin /> },
  { path: '/session/404', element: <NotFound /> },
];

export default sessionRoutes;
