#include <iostream>
#include <thread>
#include <chrono>

using namespace std;

int main() {
    string message = R"(
 ______     ______     ______        ______     ______     __         ______     ______     ______     ______     ______   __     ______     __   __    
/\  ___\   /\  ___\   /\  ___\      /\  ___\   /\  ___\   /\ \       /\  ___\   /\  == \   /\  == \   /\  __ \   /\__  _\ /\ \   /\  __ \   /\ "-.\ \   
\ \ \____  \ \ \____  \ \___  \     \ \ \____  \ \  __\   \ \ \____  \ \  __\   \ \  __<   \ \  __<   \ \  __ \  \/_/\ \/ \ \ \  \ \ \/\ \  \ \ \-.  \  
 \ \_____\  \ \_____\  \/\_____\     \ \_____\  \ \_____\  \ \_____\  \ \_____\  \ \_____\  \ \_\ \_\  \ \_\ \_\    \ \_\  \ \_\  \ \_____\  \ \_\\"\_\ 
  \/_____/   \/_____/   \/_____/      \/_____/   \/_____/   \/_____/   \/_____/   \/_____/   \/_/ /_/   \/_/\/_/     \/_/   \/_/   \/_____/   \/_/ \/_/ 
                                                                                                                                                        
 __ __ __    __                              
/  /  (_    /   _  |  _ |_  __ _ _|_ o  _ __ 
\__\____)   \__(/_ | (/_|_) | (_| |_ | (_)| |

____ ____ ____    ____ ____ _    ____ ___  ____ ____ ___ _ ____ _  _ 
|    |    [__     |    |___ |    |___ |__] |__/ |__|  |  | |  | |\ | 
|___ |___ ___]    |___ |___ |___ |___ |__] |  \ |  |  |  | |__| | \| 
                                                                     
 _____  _____  _____   _____        _        _                   _    _               
/  __ \/  __ \/  ___| /  __ \      | |      | |                 | |  (_)              
| /  \/| /  \/\ `--.  | /  \/  ___ | |  ___ | |__   _ __   __ _ | |_  _   ___   _ __  
| |    | |     `--. \ | |     / _ \| | / _ \| '_ \ | '__| / _` || __|| | / _ \ | '_ \ 
| \__/\| \__/\/\__/ / | \__/\|  __/| ||  __/| |_) || |   | (_| || |_ | || (_) || | | |
 \____/ \____/\____/   \____/ \___||_| \___||_.__/ |_|    \__,_| \__||_| \___/ |_| |_|
                                                                                      
                                                                                      
  ___   ___  ____         ___  ____  __    ____  ____  ____   __   ____  __    __   __ _ 
 / __) / __)/ ___)       / __)(  __)(  )  (  __)(  _ \(  _ \ / _\ (_  _)(  )  /  \ (  ( \
( (__ ( (__ \___ \      ( (__  ) _) / (_/\ ) _)  ) _ ( )   //    \  )(   )(  (  O )/    /
 \___) \___)(____/       \___)(____)\____/(____)(____/(__\_)\_/\_/ (__) (__)  \__/ \_)__)

   ____     ____    _____        ____    _____   _____        _____   ______    ______       ____     ________    _____     ____        __      _  
  / ___)   / ___)  / ____\      / ___)  / ___/  (_   _)      / ___/  (_   _ \  (   __ \     (    )   (___  ___)  (_   _)   / __ \      /  \    / ) 
 / /      / /     ( (___       / /     ( (__      | |       ( (__      ) (_) )  ) (__) )    / /\ \       ) )       | |    / /  \ \    / /\ \  / /  
( (      ( (       \___ \     ( (       ) __)     | |        ) __)     \   _/  (    __/    ( (__) )     ( (        | |   ( ()  () )   ) ) ) ) ) )  
( (      ( (           ) )    ( (      ( (        | |   __  ( (        /  _ \   ) \ \  _    )    (       ) )       | |   ( ()  () )  ( ( ( ( ( (   
 \ \___   \ \___   ___/ /      \ \___   \ \___  __| |___) )  \ \___   _) (_) ) ( ( \ \_))  /  /\  \     ( (       _| |__  \ \__/ /   / /  \ \/ /   
  \____)   \____) /____/        \____)   \____\ \________/    \____\ (______/   )_) \__/  /__(  )__\    /__\     /_____(   \____/   (_/    \__/    
                                                                                                                                                   
   ______   ______   _____          ______          __          __                     __     _                
  / ____/  / ____/  / ___/         / ____/  ___    / /  ___    / /_    _____  ____ _  / /_   (_)  ____    ____ 
 / /      / /       \__ \         / /      / _ \  / /  / _ \  / __ \  / ___/ / __ `/ / __/  / /  / __ \  / __ \
/ /___   / /___    ___/ /        / /___   /  __/ / /  /  __/ / /_/ / / /    / /_/ / / /_   / /  / /_/ / / / / /
\____/   \____/   /____/         \____/   \___/ /_/   \___/ /_.___/ /_/     \__,_/  \__/  /_/   \____/ /_/ /_/ 
                                                                                                               
  ___   ___  ___    ___       _       _                _    _            
 / __| / __|/ __|  / __| ___ | | ___ | |__  _ _  __ _ | |_ (_) ___  _ _  
| (__ | (__ \__ \ | (__ / -_)| |/ -_)| '_ \| '_|/ _` ||  _|| |/ _ \| ' \ 
 \___| \___||___/  \___|\___||_|\___||_.__/|_|  \__,_| \__||_|\___/|_||_|
                                                                         
 ______     ______     ______        ______     ______     __         ______     ______     ______     ______     ______   __     ______     __   __    
/\  ___\   /\  ___\   /\  ___\      /\  ___\   /\  ___\   /\ \       /\  ___\   /\  == \   /\  == \   /\  __ \   /\__  _\ /\ \   /\  __ \   /\ "-.\ \   
\ \ \____  \ \ \____  \ \___  \     \ \ \____  \ \  __\   \ \ \____  \ \  __\   \ \  __<   \ \  __<   \ \  __ \  \/_/\ \/ \ \ \  \ \ \/\ \  \ \ \-.  \  
 \ \_____\  \ \_____\  \/\_____\     \ \_____\  \ \_____\  \ \_____\  \ \_____\  \ \_____\  \ \_\ \_\  \ \_\ \_\    \ \_\  \ \_\  \ \_____\  \ \_\\"\_\ 
  \/_____/   \/_____/   \/_____/      \/_____/   \/_____/   \/_____/   \/_____/   \/_____/   \/_/ /_/   \/_/\/_/     \/_/   \/_/   \/_____/   \/_/ \/_/ 
                                                                                                                                                        

    )";

    for (char c : message) {
        cout << c << flush; // Print the current character
        this_thread::sleep_for(chrono::milliseconds(1)); // Delay for typing effect
    }

    cout << endl;
    return 0;
}
