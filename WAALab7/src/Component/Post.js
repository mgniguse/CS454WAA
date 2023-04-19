import React, { useState } from 'react'
import PostDetails from './PostDetails'

function Post(props) {
 
  return (
    <div className="Content">
      <h3>ID: {props.id}</h3>
      <h3>Author: {props.author}</h3>
      <h3>Title: {props.title}</h3>
    </div>
  )
}

export default Post