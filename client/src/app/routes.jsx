import AuthGuard from 'app/auth/AuthGuard';
import dashboardRoutes from 'app/views/dashboard/DashboardRoutes';
import NotFound from 'app/views/sessions/NotFound';
import sessionRoutes from 'app/views/sessions/SessionRoutes';
import { Navigate } from 'react-router-dom';

import Layout1 from "./components/MatxLayout/Layout1/Layout1";

const routes = [
  {
    element: (
      <AuthGuard>
        <Layout1/>
      </AuthGuard>
    ),
    children: [...dashboardRoutes],
  },
  ...sessionRoutes,
  { path: '/login', element: <Navigate to="login" />},
  { path: '*', element: <NotFound /> },
];

export default routes;
