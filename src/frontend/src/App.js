import {getAllMedias} from "./client";
import {useState, useEffect} from "react";
import {Empty, Spin} from "antd";
import { LoadingOutlined } from '@ant-design/icons';
import './App.css';

const antIcon = <LoadingOutlined style={{fontSize: 24}} spin/>;

function App() {
    const [medias, setMedias] = useState([]);
    const [fetching, setFetching] = useState(true)

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
        <div>
        {renderMedias()}
        </div>
    )
}

export default App;
