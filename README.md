# Solution

- Author : Frederic Lemieux
- All dependencies are justified in the gradle files by comments.
- Continuous integration done with Circle ci
  [![Build Status](https://app.bitrise.io/app/f1362518ed78d5e0/status.svg?token=YzVQM-fRKzIxYj14KWidGA&branch=master)](https://app.bitrise.io/app/f1362518ed78d5e0)
- the project respect clean architecture and modular architecture.
- Used jetpack compose !!!
- Used COIL library for the Image Loading for easy remote access and caching feature.


# Android technical test - SWILE

Show list of of transactions and details screen on click on the items of the list
Using this api :  https://gist.githubusercontent.com/Aurazion/365d587f5917d1478bf03bacabdc69f3/raw/3c92b70e1dc808c8be822698f1cbff6c95ba3ad3/transactions.json

Details of the test : 
https://swile.notion.site/Swile-Test-technique-725c202ce6c74a0c8cf01c1febee9951

Figma:
https://www.figma.com/file/RHXIwiNuKsNUpuMuy7kh1S/Screens---Test-technique-Swile?node-id=201%3A18332

## Explanations :

- Architecture : Clean Architecture
    - Presenter :
        - Activity
        - Screen
        - components (TransactionHeader, TransactionItem, Details)
        - State
        - ViewModel
    - Domain :
        - Model / Entity
        - Repository interface
        - Use case
    - Data :
        - local
        - remote
        - repository Implementation

- Design patterns :
    - Adapter
    - Singleton
    - Facade

- Libraries :
    - check the gradle file in the app directory (app/build.gradle)

- Handle :
    - Caching, change orientation
    - High Performance
    - Tests
    - UI / UX



