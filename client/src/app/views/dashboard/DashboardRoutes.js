import Loadable from 'app/components/Loadable';
import { lazy } from 'react';
import { authRoles } from '../../auth/authRoles';
import Listusers from "./user/Listusers";
import Profiluser from "./user/Profiluser";
import Product from "./Prouduct/product";
import Event from "./event/event";
import Tools from "./tools/tools";

const Analytics = Loadable(lazy(() => import('./Analytics')));

const dashboardRoutes = [
  { path: '/dashboard', element: <Analytics />, auth: authRoles.admin },
  { path: '/dashboard/listusers', element: <Listusers />, auth: authRoles.admin },
  { path: '/dashboard/profil', element: <Profiluser />, auth: authRoles.admin },
  { path: '/dashboard/event', element: <Event />, auth: authRoles.admin },
  { path: '/dashboard/product', element: <Product />, auth: authRoles.admin },
  { path: '/dashboard/tools', element: <Tools />, auth: authRoles.admin },
];

export default dashboardRoutes;
