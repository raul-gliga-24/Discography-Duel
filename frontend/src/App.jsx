import { useState,useEffect } from "react";

export default function App(){

    const [status,setStatus] = useState(null);
    const [error,setError] = useState(null);


    useEffect(() => {
      async function load() {
        try{
          const res = await fetch("http://localhost:8080/api/ping");
          if(!res.ok)
            throw new Error(`HTTP ${res.status}`);

          const data = await res.json();

          setStatus(data);
        }catch(e){
          setError(e.message);
        }
        
      }
      load();




    },[]);


    if (error)
      return <p>
        Backend Unreachable: {error}


      </p>

    if (!status)
      return <p>
        Loading..
      </p>

    return <h1>
      {status.app} is {status.status}

    </h1>


}
