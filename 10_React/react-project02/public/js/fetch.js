// fetch('https://jsonplaceholder.typicode.com/posts/2')
//     .then(response => response.json())
//     .then(json => {
//         console.log(json)
//     })
//     .catch(err =>{
//         console.log("error", err)
//     })

async function getdkanro() {
  try {
    const response = await fetch('https://jsonplaceholder.typicode.com/posts/2');
    if (!response.ok) throw new Error('서버에서 오류 발생');
    console.log(response);
    const data = await response.json();
    console.log(data);
  } catch (err) {
    console.log(err);
  }
}

getdkanro();
