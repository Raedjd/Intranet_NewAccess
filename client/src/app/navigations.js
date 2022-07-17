export const navigations = [
  { name: 'Dashboard', path: '/dashboard', icon: 'dashboard' },
  { label: 'PAGES', type: 'label' },
  {
    name: 'Users',
    icon: 'accessibility',
    children: [
      { name: 'All users', iconText: 'account_circle', path: '/dashboard/listusers',icon: ' wc' },
      { name: 'Profil', iconText: 'SI', path: '/dashboard/profil',icon: 'account_circle' },

    ],
  },
  {
    name: 'Events',
    icon: 'nature_people',
    children: [
      { name: 'Add event', iconText: 'account_circle', path: '/dashboard/event',icon: ' cake' },


    ],
  },

  {
    name: 'Products',
    icon: 'local_parking',
    children: [
      { name: 'Add product', iconText: 'account_circle', path: '/dashboard/product',icon: ' add_circle' },


    ],
  },
  {
    name: 'Tools',
    icon: 'build',
    children: [
      { name: 'Add tools', iconText: 'account_circle', path: '/dashboard/tools',icon: 'desktop_mac' },


    ],
  },



  { label: 'Components', type: 'label' },
  {
    name: 'Components',
    icon: 'favorite',
    badge: { value: '30+', color: 'secondary' },
    children: [
      { name: 'Auto Complete', path: '/material/autocomplete', iconText: 'A' },
      { name: 'Buttons', path: '/material/buttons', iconText: 'B' },
      { name: 'Checkbox', path: '/material/checkbox', iconText: 'C' },
      { name: 'Dialog', path: '/material/dialog', iconText: 'D' },
      { name: 'Expansion Panel', path: '/material/expansion-panel', iconText: 'E' },
      { name: 'Form', path: '/material/form', iconText: 'F' },
      { name: 'Icons', path: '/material/icons', iconText: 'I' },
      { name: 'Menu', path: '/material/menu', iconText: 'M' },
      { name: 'Progress', path: '/material/progress', iconText: 'P' },
      { name: 'Radio', path: '/material/radio', iconText: 'R' },
      { name: 'Switch', path: '/material/switch', iconText: 'S' },
      { name: 'Slider', path: '/material/slider', iconText: 'S' },
      { name: 'Snackbar', path: '/material/snackbar', iconText: 'S' },
      { name: 'Table', path: '/material/table', iconText: 'T' },
    ],
  },
  {
    name: 'Charts',
    icon: 'trending_up',
    children: [{ name: 'Echarts', path: '/charts/echarts', iconText: 'E' }],
  },
  {
    name: 'Documentation',
    icon: 'launch',
    type: 'extLink',
    path: 'http://demos.ui-lib.com/matx-react-doc/',
  },
];
