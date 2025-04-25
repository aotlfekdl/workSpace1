import React, {Component} from 'react'
import Comment from './Comment'

const serverComments = [{
    id :  1,
    message : "안녕하세요 최지원입니다. ",
},{
    id :  2,
    message : "이제 여름이 시작하나요? ",
},{
    id :  3,
    message : "냉면 먹고 싶습니다. ",
},
]

class CommentList extends Component{
    constructor(props){
        super(props);

        this.state = {
            commentList : [],
        }
    }

    ComponentDidMount(){
        //setInterval : 일정시간마다 반복해서 동작하는 비동기 함수
        setInterval(() => {
            const {commentList} = this.state;
            if(commentList.length < serverComments.length){
                const nextComment = serverComments[commentList.length];
                
             
                this.setState({
                    commentList : [...commentList, nextComment],
                });

            }else{
                this.setState({
                    commentList : []
                });
            }
        }, 3000);

    }



    render(){
        return (
         <div>
            {this.state.commentList.map(c => <Comment Key={c.id}
                                                        id={c.id}
                                                        message={c.message}
            ></Comment>)}
         </div>  
        )
    }
}