import {useState, useEffect} from "react";
import {getAllMedias} from "./client";
import {Empty, Spin, Layout, Menu, Breadcrumb, Table} from "antd";
import { LoadingOutlined, DesktopOutlined, UserOutlined, FileOutlined, PieChartOutlined, TeamOutlined } from '@ant-design/icons';
import './App.css';

const { Header, Content, Footer, Sider } = Layout;
const {SubMenu} = Menu;
const antIcon = <LoadingOutlined style={{fontSize: 24}} spin/>;

function App() {
    const [medias, setMedias] = useState([]);
    const [fetching, setFetching] = useState(true)
    const [collapsed, setCollapsed] = useState(false);

    const fetchMedias = () =>
        getAllMedias()
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setMedias(data);
                setFetching(false);
            })

    useEffect(() => {
        console.log('component is mounted')
        fetchMedias();
    }, []);

    if (medias.length <= 0) {
        return "no data";
    }

    const renderMedias = () => {
        if (fetching) {
            return <Spin indicator={antIcon} />
        }
        if (medias.length <= 0) {
            return <Empty />;
        }
        return medias.map((media, index) => {
            return <p key={index}>{media.id} {media.name} {media.description} {media.source} {media.audio} {media.image} {media.title} {media.likes} {media.dislikes} {media.type} </p>
        });

    }

    return (
        // <div>
        // {renderMedias()}
        // </div>
        <Layout style={{minHeight: '100vh'}}>
            <Sider collapsible collapsed={collapsed}
                   onCollapse={setCollapsed}>
                <div className="logo"/>
                <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
                    <Menu.Item key="1" icon={<PieChartOutlined/>}>
                        Option 1
                    </Menu.Item>
                    <Menu.Item key="2" icon={<DesktopOutlined/>}>
                        Option 2
                    </Menu.Item>
                    <SubMenu key="sub1" icon={<UserOutlined/>} title="User">
                        <Menu.Item key="3">Tom</Menu.Item>
                        <Menu.Item key="4">Bill</Menu.Item>
                        <Menu.Item key="5">Alex</Menu.Item>
                    </SubMenu>
                    <SubMenu key="sub2" icon={<TeamOutlined/>} title="Team">
                        <Menu.Item key="6">Team 1</Menu.Item>
                        <Menu.Item key="8">Team 2</Menu.Item>
                    </SubMenu>
                    <Menu.Item key="9" icon={<FileOutlined/>}>
                        Files
                    </Menu.Item>
                </Menu>
            </Sider>
            <Layout className="site-layout">
                <Header className="site-layout-background" style={{padding: 0}}/>
                <Content style={{margin: '0 16px'}}>
                    <Breadcrumb style={{margin: '16px 0'}}>
                        <Breadcrumb.Item>User</Breadcrumb.Item>
                        <Breadcrumb.Item>Bill</Breadcrumb.Item>
                    </Breadcrumb>
                    <div className="site-layout-background" style={{padding: 24, minHeight: 360}}>
                        {renderMedias()}
                    </div>
                </Content>
                <Footer style={{textAlign: 'center'}}>By Tiffany D ©2022</Footer>
            </Layout>
        </Layout>
    )
}

export default App;

