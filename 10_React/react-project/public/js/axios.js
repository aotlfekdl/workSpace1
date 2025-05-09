import axios from "axios";


// axios.get("https://jsonplaceholder.typicode.com/posts/1")
//   .then(response => {
//     console.log("받은 데이터:", response.data); // 바로 data!
//   })
//   .catch(error => {
//     console.error("에러 발생:", error);
//   });

async function getPost() {
    try{
        const response = await axios.get("https://jsonplaceholder.typicode.com/posts/1");
        console.log("받은 데이터:", response.data);
    }catch(Error){
        console.error("에러 발생:", error);
    }
    
}


getPost();