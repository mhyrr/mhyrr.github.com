#!/usr/bin/ruby


def get_doors
  doors = %w(goat goat goat)
  car = rand(3)
  doors[car] = "car"
  
  doors
end

def get_goat(doors, pick)
  
  while true
    try = rand(3)
    if doors[try] == "goat" and try != pick
      return try
    end
  end
  
end  

def dont_switch
  correct = 0
  picks = [0,0,0]
  goats = [0,0,0]
  
  (1..1_000_000).each do |n|
    
    doors = get_doors
    
    pick = rand(3)
    picks[pick] += 1
    show = get_goat(doors, pick)
    goats[show] += 1
    
    correct += if doors[pick] == "car"
      1
    else
      0
    end
    
  end
  
  puts "DO NOT SWITCH DOORS: 1,000,000 trials conducted\n\nResults:\n"
  puts "\tPick Distribution:\n\t\tDoor 1:\t#{picks[0]}\n\t\tDoor 2:\t#{picks[1]}\n\t\tDoor 3:\t#{picks[2]}"
  puts "\tGoat Distribution:\n\t\tDoor 1:\t#{goats[0]}\n\t\tDoor 2:\t#{goats[1]}\n\t\tDoor 3:\t#{goats[2]}"
  printf("Correct: #{correct}, %2.0f%\n", 100*(correct.to_f/1_000_000.to_f) )
  printf("Incorrect: #{1_000_000 - correct}, %2.0f%\n", ((1_000_000 - correct).to_f / 1_000_000.to_f)* 100)
    
end

def get_new_pick(pick, show)
  
  if pick == 0
    if show == 1
      new_door = 2
    else
      new_door = 1
    end
  elsif pick == 1
    if show == 0
      new_door = 2
    else 
      new_door = 0
    end
  else
    if show == 0
      new_door = 1
    else
      new_door = 0
    end
  end
  
end

def do_switch
  correct = 0
  picks = [0,0,0]
  goats = [0,0,0]
  switches = [0,0,0]
  
  (1..1_000_000).each do |n|
    
    doors = get_doors
    
    pick = rand(3)
    picks[pick] += 1
    show = get_goat(doors, pick)
    goats[show] += 1
    new_door = get_new_pick(pick, show)
    switches[new_door] += 1
    
    correct += if doors[new_door] == "car"
      1
    else
      0
    end
    
  end
  
  puts "\n=====\n\n\nSWITCH DOORS: 1,000,000 trials conducted\n\nResults:\n"
  puts "\tPick Distribution:\n\t\tDoor 1:\t#{picks[0]}\n\t\tDoor 2:\t#{picks[1]}\n\t\tDoor 3:\t#{picks[2]}"
  puts "\tGoat Distribution:\n\t\tDoor 1:\t#{goats[0]}\n\t\tDoor 2:\t#{goats[1]}\n\t\tDoor 3:\t#{goats[2]}"
  puts "\tSwitch Distribution:\n\t\tDoor 1:\t#{switches[0]}\n\t\tDoor 2:\t#{switches[1]}\n\t\tDoor 3:\t#{switches[2]}" 
    
  printf("Correct: #{correct}, %2.0f%\n", 100*(correct.to_f/1_000_000.to_f) )
  printf("Incorrect: #{1_000_000 - correct}, %2.0f%\n", ((1_000_000 - correct).to_f / 1_000_000.to_f)* 100)
  
end

dont_switch
do_switch
