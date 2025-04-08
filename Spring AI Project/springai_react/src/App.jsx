import React, { useState } from 'react';
import './App.css';

function App() {
  const [prompt, setPrompt] = useState('');
  const [response, setResponse] = useState('');
  const [loading, setLoading] = useState(false);

  const handleSend = async () => {
    if (!prompt.trim()) return;

    setLoading(true);
    setResponse('');

    try {
      const res = await fetch(`http://localhost:8080/api?prompt=${encodeURIComponent(prompt)}`);
      const data = await res.text();  // backend returns plain text
      setResponse(data);
    } catch (error) {
      setResponse('Error fetching response.');
      console.error(error);
    }

    setLoading(false);
  };

  return (
    <div className="App">
      <h1>Ollama Chat</h1>
      <div className="chat-container">
        <textarea
          placeholder="Ask something..."
          value={prompt}
          onChange={(e) => setPrompt(e.target.value)}
        />
        <button onClick={handleSend} disabled={loading}>
          {loading ? 'Thinking...' : 'Send'}
        </button>
        <div className="response-box">
          {response && <p><strong>Ollama:</strong> {response}</p>}
        </div>
      </div>
    </div>
  );
}

export default App;
