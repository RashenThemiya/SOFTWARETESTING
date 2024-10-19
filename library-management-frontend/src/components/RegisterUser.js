import React, { useState } from 'react';
import { registerUser } from '../services/userService';

const RegisterUser = ({ setErrorMessage, setSuccessMessage }) => {
  const [newUser, setNewUser] = useState({ username: '', password: '', role: 'user' });

  const handleRegisterUser = () => {
    if (!newUser.username || !newUser.password) {
      setErrorMessage('Please fill in both username and password.');
      return;
    }

    registerUser(newUser)
      .then(() => {
        setSuccessMessage('User registered successfully!');
        setNewUser({ username: '', password: '', role: 'user' }); // Reset input fields
      })
      .catch(error => {
        console.error('Error registering user', error);
        setErrorMessage(error.response.data || 'Failed to register user. Please try again.');
      });
  };

  return (
    <div className="p-4 border rounded bg-light registernewuser"> {/* Bootstrap container styling */}
      <h2 className="text-center">Register New User</h2> {/* Centered title */}
      <div className="mb-3">
        <input
          className="form-control" // Bootstrap form control class
          type="text"
          placeholder="Username"
          value={newUser.username}
          onChange={(e) => setNewUser({ ...newUser, username: e.target.value })}
        />
      </div>
      <div className="mb-3">
        <input
          className="form-control" // Bootstrap form control class
          type="password"
          placeholder="Password"
          value={newUser.password}
          onChange={(e) => setNewUser({ ...newUser, password: e.target.value })}
        />
      </div>
      <div className="mb-3">
        <select
          className="form-select" // Bootstrap select class
          value={newUser.role}
          onChange={(e) => setNewUser({ ...newUser, role: e.target.value })}
        >
          <option value="user">User</option>
          <option value="admin">Admin</option>
        </select>
      </div>
      <button className="btn btn-primary w-100" onClick={handleRegisterUser}>Register User</button> {/* Full-width button */}
    </div>
  );
};

export default RegisterUser;
