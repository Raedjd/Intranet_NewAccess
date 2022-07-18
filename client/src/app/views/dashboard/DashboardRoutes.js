import Loadable from 'app/components/Loadable';
import { lazy } from 'react';
import Listusers from "./user/Listusers";
import Profiluser from "./user/Profiluser";
import Product from "./Prouduct/product";
import Event from "./event/event";
import Tools from "./tools/tools";
import Listevent from "./event/Listevent";
import Actuality from "./Actuality/actuality";
import Admin from "./admin";

const Analytics = Loadable(lazy(() => import('./Analytics')));

const dashboardRoutes = [
  { path: '/dashboard', element: <Analytics /> },
  { path: '/dashboard/admin', element: <Admin />},
  { path: '/dashboard/actuality', element: <Actuality/>},
  { path: '/dashboard/listusers', element: <Listusers />},
  { path: '/dashboard/profil', element: <Profiluser />},
  { path: '/dashboard/event', element: <Event />},
  { path: '/dashboard/listevents', element: <Listevent/>},
  { path: '/dashboard/product', element: <Product />},
  { path: '/dashboard/tools', element: <Tools />},
];

export default dashboardRoutes;
