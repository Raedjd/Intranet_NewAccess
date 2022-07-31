import { routsData } from 'app/auth/RoutsData';
import Loadable from 'app/components/Loadable';
import { lazy } from 'react';

const AppEchart = Loadable(lazy(() => import('./echarts/AppEchart')));

const chartsRoute = [{ path: '/charts/echarts', element: <AppEchart />, auth: routsData.editor }];

export default chartsRoute;
