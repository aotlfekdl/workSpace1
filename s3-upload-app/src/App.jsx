import React, { useState } from "react";
import axios from "axios";
import { v4 as uuidv4 } from "uuid";
import "./App.css";

function App() {
  const [file, setFile] = useState(null);
  const [downloadFileInfo, setDownloadFileInfo] = useState(null);
  const [status, setStatus] = useState('');

  // const handleFileChange = (e) => {
  //   const selectedFile = e.target.files[0];
  //   setFile(selectedFile);
  //   setSelectedFileName(selectedFile ? selectedFile.name : "");
  // };

  const uploadFile = async () => {
    if (!file) return alert("파일을 선택하세요");

    try {
      setStatus("업로드 중...");

      // 파일 확장자 추출
      const extension = file.type.split("/").pop();
      const uniqueFilename = `${uuidv4()}.${extension}`;
      const encodedFilename = encodeURIComponent(uniqueFilename);

      // Step 1: Lambda API 호출 → Presigned URL 받기
      const response = await axios.get(lambdaAPI, {
        params: {
          filename: `user-profile/${encodedFilename}`,
          contentType: file.type,
        },
      });
      console.log(response.data);
      const { statusCode, body } = response.data;
    

      if (statusCode === 200) {
        const bodyData = JSON.parse(body); // 중첩된 JSON 문자열 처리
        const presignedUrl = bodyData.url;
        // 2. Presigned URL을 통해 S3에 직접 업로드
        await axios.put(presignedUrl, file, {
          headers: {
            "Content-Type": file.type,
          },
        });
  
        
        setDownloadFileName(encodedFilename)
        if(path){
          setUploadProfile(path + encodedFilename);
        }
        setStatus("업로드 완료!");
      } else {
        console.error("Presigned URL 요청 실패:", response.data);
        setStatus("업로드 실패");
      }
    } catch (err) {
      console.error(err);
      setStatus("업로드 실패");
    }
  };

  const downloadFile = async () => {
    if (!downloadFileName) return alert("다운로드할 파일명을 입력하세요");

    try {
      setStatus("다운로드 URL 생성 중...");
      // Step 1: Lambda 호출 → 다운로드용 Presigned URL 받기
      const response = await axios.get("게이트웨이API", {
        params: {
          filename: downloadFileName,
          mode: "get", 
          originalName: originalName,
        },
      });
      
      const { statusCode, body } = response.data;

      if (statusCode === 200) {
        const bodyData = JSON.parse(body);
        console.log(bodyData);
        const downloadUrl = bodyData.url;
  
        // 새 창으로 다운로드 시작
        window.open(downloadUrl, "_blank");
        setStatus("다운로드 준비 완료");
      } else {
        console.error("다운로드 URL 요청 실패:", response.data);
        setStatus("다운로드 실패");
      }
    } catch (err) {
      console.error(err);
      setStatus("다운로드 실패");
    }
  };

  return (
    <div className="app-container">
      <h1>S3 파일 업로드/다운로드</h1>
      
      <div className="upload-section">
        <h2>파일 업로드</h2>
        <input type="file" onChange={handleFileChange} />
        <button onClick={uploadFile} disabled={!file}>
          업로드
        </button>
      </div>

      <div className="download-section">
        <h2>파일 다운로드</h2>
        <input
          type="text"
          value={downloadFileName}
          onChange={(e) => setdownloadFileName(e.target.value)}
          placeholder="다운로드할 파일명 입력"
        />
        <button onClick={downloadFile} disabled={!downloadFileName}>
          다운로드
        </button>
      </div>

      <div className="status">
        <p>{status}</p>
      </div>
    </div>
  );
}

export default App;
