// SPDX-License-Identifier: MIT
pragma solidity >=0.5.0 <0.9.0;

contract Bank{
    mapping (address => uint256) private balances;

    event Deposite( address depositer , uint amount);
    event Withdreal( address withdrewal , uint amount);

  // deposit money into bank
  function deposit() public payable {
    require(msg.value >0 ,"Deposite money must be greater than zero");
    balances[msg.sender] += msg.value;
    emit Deposite(msg.sender, msg.value);
  }

  //withdrewal money from bank
  function withdrw(uint256 amount) public {
    require(amount < balances[msg.sender] ," Insufficient balance");
    balances[msg.sender] -= amount;
    payable(msg.sender).transfer(amount);
    emit Withdreal(msg.sender , amount);
   
  }
  // getbalance
  function getBalance() public view returns (uint256){
    return balances[msg.sender];
  }
}
