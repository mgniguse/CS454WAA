import React from 'react'
import Post from '../Component/Post';

function Posts(props) {
  
  return(
    <div>
      {props.data.map(p=>{
        return <Post id={p.id} key={p.id}title={p.title} author={p.author}/>
      })
      }
    </div>
   
  )
}

export default Posts