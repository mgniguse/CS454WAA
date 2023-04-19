import React from 'react'

function PostDetails(props) {
  return (
    <div>
        {console.log(props)}
        <h3>{props.postDetails.title}</h3>
        <h5>{props.postDetails.title}</h5>
        <p>This is the content in the post ...</p>
        <button style={{ color: 'red', lineHeight : 10, padding: 20 }}>Edit</button>
        <button>Delete</button>
    </div>
  )
}

export default PostDetails