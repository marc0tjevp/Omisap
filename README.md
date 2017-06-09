## Getting Started
---
#### Communication
We use [Slack](https://pasimo.slack.com/) for internal communication and announcements. Contact [Jordy](mailto:jpijpelink1@student.scalda.nl) to get access.

#### Documentation
Most of Pasimo's documentation can be found on [SharePoint](https://scalda365.sharepoint.com/sites/pasimo/Gedeelde%20%20documenten/Forms/AllItems.aspx]). Contact [Rens Brandon](mailto:rbrandon@scalda.nl) to get access.
All models, diagrams and mockups can be found on [Lucidchart](https://www.lucidchart.com/invitations/accept/002e459d-980b-4f9f-9c08-38c7577ba46b).

#### Planning
Sprints and their user stories can be found on [Jira](http://82.176.177.105:8080/secure/Dashboard.jspa).

#### Must Read
[Product Vision Board](https://scalda365.sharepoint.com/sites/pasimo/_layouts/15/guestaccess.aspx?guestaccesstoken=XyYw%2fz62khuLXblzP4pieYZXyT2RCMCab6lv%2bemMw1s%3d&docid=2_047a9ebe4ee434fbdbc2e95e351279b19&rev=1)
[Code Conventions](https://scalda365.sharepoint.com/sites/pasimo/_layouts/15/WopiFrame.aspx?sourcedoc=%7B1E7E484E-09D8-4E8D-82B9-1C8B1F803EF0%7D&file=Programmeer%20Conventies.docx&action=default)

## Cloning the Project
---
#### Terminal/GIT
To clone the project using the terminal, use the following command. [Make sure GIT is installed](https://www.atlassian.com/git/tutorials/install-git). Change 'username' to your BitBuket username.

``` bash
git clone https://username@bitbucket.org/pasimo/pasimo.git
```

#### SourceTree
To clone the project using SourceTree, go to 'Tools > Options > Authentication'. Click on 'Add Account' and log in to your BitBucket.
Next, go to 'File > Clone/New' and click on the 'Remote' button. Click on the clone link next to Pasimo.

#### GitKraken
To  clone the project using GitKraken, click on the folder icon in the left corner. Click on the 'Clone' tab and choose 'Bitbucket.org'. Click the 'Connect to BitBucket' button and enter your credentials.
When connected you will be able to locate the pasimo repository in the clone window.

## Opening Project
---
#### Eclipse (Java EE)
To open the project in Eclipse, go to 'File > Import...' and choose the 'Maven' folder. Next choose 'Existing Maven Project' and click next.
Locate the project folder by clicking 'Browse...'. Then select Pasimo and click the 'Finish' button.

To run you project you will need to configure Tomcat. Click on 'Window > Show View > Servers'. A modal will pop up, click on the link in it.
Next, select Tomcat v8.0 and click next. In this screen you can add the serer to available projects. Add Pasimo and click 'Finish'.

Right click on the project and click on 'Run as... > Run on Server', this will build and start the project.

#### Netbeans (Java EE)
To open the project in Netbeans it's important that you have chosen Apache Tomcat in the installation. If you did not choose Apache, you can [download the latest installer](https://netbeans.org/downloads/index.html) and tick the Apache Tomcat checkbox to install it.

Click on the third icon in the toolbar or go to 'File > Open Project'. Locate the project on your hard disk, you have to select the 'app' folder and click on 'Open Project'.
Next, click on the Play button in the toolbar or rightclik on the Pasimo project and choose 'Run'.
