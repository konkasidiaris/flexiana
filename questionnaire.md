A part of our interview process is a questionnaire & test task. Here, I am sending the questionnaire.

• What is your favorite branching model?
GitFlow
• When do you use unit tests and when integration tests?
Unit is a function or a sequence of functions that do not have I/O operations
Thus unit tests are written to test functions which are self contained in the code with every dependency mocked (databases, services etc)
Integration tests to test how the app interacts with real databases and external services
• How can you eliminate or lower null pointer exceptions?
By providing default values to data structures as well as checks at every I/O point of the application
• Can you name one of big development issues you have faced and how did you resolve it?
When I first came to work to my current employer, the app I was supposed to help develop to, was full of untraceable bugs and everyone was in a rush.
What I did was to guide the team to create some rules to follow (eg. no commented out code, If we need something, we can trace it with git)
So every noisy commented out code was deleted.
Then I shared with the team the two rules of every well engineered product.

1. It changes easily
2. It complies with the business needs
   The order is a must. Code should change easily.
   This lead to a series of refactors as the next feature was built.
   This also had another side effect. The code was clean enough to spot business corner cases as well as bottlenecks in performance.
   Long story short a node.js app went from 120k lines to 47k lines with more features, better performance and less bugs in about 3 months.
   • What are the general guidelines to build horizontally scalable application?
   The applications should be stateless
   • How do you describe clean code?
   Coding is actually a soft skills problem. Machines can understand the same good or bad code. Developers do not.
   For me, clean code is the code that I understand what it does, why it does things this way and most importantly, can change easy according to business needs.
   • What are application security best practices?
   I currently follow OWASP. The top 10 list is a must.
   • How would you resolve DoS attack?
   It depends on the type of the attack. A limiter could help. Also avoiding regexp.
   Deleting dead code as well as check every input helps too.
   Using a firewall to block IPs from places that should not have access to the app
   Filtering requests by user agent
   • What code would you comment?
   Comments should tell the story behind the WHY this approach was selected. Everyone can read what the code does.
   So every public function as well as endpoints should be documented on why they are in need and what business value they bring.
   • Have you developed any macros? If so, for what purpose?
   No, the test task is actually my third attempt on clojure. My experience as for now is on languages that do not support macros.
   • If you application is slow, how would you approach it?
   There are four distinct parts in every application
   Client Load-balancer Server DB
   If the whole application was slow then it should be a generic flaw, as an old server machine etc. (I would try to upgrade it), not zipped payloads (gzip, snappy)
   Given that only a click of a button had slow results and the rest of the application was fast enough
3. I would open dev tools to examine the network waterfall to case out the client app (maybe there was a fault and the endpoint was hit thousands of times in a click, maybe there was a bad render, maybe something should be served from a CDN)
4. Ruled out the client fault, I would check the logs on server while I send requests from the client. If they had a delay, I would check the load balancer
5. Ruled out the load balancer, I would check the flow on the server. A bad algorithm or several calls to the database could create the issue. Maybe even a call on an external api. (there could be some intel from the APM)
6. Ruled out the server I would check the database, process cpu, network usage and ram metrics to provide me with more info. If a query is slow (a join of joins for example) I would check how to get better performance by indexing or denormalising that. I would check the profiler for further info
   • What are the best practices for config management?
   I am not familiar with the term config management. From a quick googling I see that this is about Infrastructure as Code (using tools like Vagrant, Puppet and Terraform). To be honest I do not know, I have used only Heroku PaaS
   • What are main issues of apps that run in around-the-world datacenters?
   I have not experience on running an application outside of Greece. I guess that syncing the data would be an issue as well as latency.
   • How would you replace Factory design pattern in functional programming?
   Factory Pattern is a glorified if. I guess that a function encapsulating this if should do the work. In JS I personally like using maps that have as keys the term I am checking for and as values the reference to the respecting function
   • What is Scrum, Sprint, Planning, Product Owner & Scrum Master?
   Scrum: A framework based on agile principles. Its name is given by the scrum of rugby. It consists of 4 (timeboxed) ceremonies (planning, daily stand up, grooming, retrospective). Separates the dev time in iterations (sprints).
   Sprint: The iterations of scrum (1-4 weeks, 2 is the most common)
   Planning: A ceremony of the scrum team where according to the team velocity, the team evaluates the future tasks and the product owner selects which should be developed in the running sprint
   Product Owner: The connection of the team to the stakeholders. Is in charge of the product backlog. PO is the only member of the team that does not take place into daily scrum
   Scrum Master: (In my opinion it is the most difficult role) Takes care of the team, removing every obstacle in their way to success. Leads the ceremonies and solves every problem of its teamates.
   • How agile retrospective looks like?
   Retrospective is actually a feedback loop of the team to the team performance. The team is gathered to talk about what went right(to keep) and what went wrong(to fix) during the last sprint.
   Everyone shall come to the ceremony with the following mindset "Everybody did their best during the circumstances they faced at the current time" only to become better
   • How would you build a team methodology?
   The team should make the rules. Through trial and error (facts cannot be questioned) the team should test and evaluate if the rules (the team) introduced are here to stay or not.
   The rules and the changes shall be gradual and the goals of the team SMART (specific, measurable, achievable, relevant, timeboxed)
   • A customer is pushing you to a code that's going to be unmaintainable. How would you resolve it?
   If I understand it correctly, you are using scrum thus I would talk to the scrum master to resolve the issue.
   If I did not understand it correctly, I would explain to the customer that bad quality in code is loss of money for them. I would neither build a skyscraper on sand if I was a civil engineer, nor an unmaintainable application for a customer as a SWE. Just because you do not see the mess, it does not mean that it is non existent.
   • You see a colleague has huge productivity issues, how would you resolve it?
   I do not know the dynamics of the team, the culture of the company and the level of diversity to give an answer.
   • You find a security bug in your app. How would you proceed?
   I would check the SLA, inform the dev team and check the level of threat.
   Then I would proceed to a fix or do nothing at all according to how the bug affects the app. (eg. the 14.17.3 version of node fixed a security bug on the installer of windows. Everyone on my team uses mac and the app is deployed on ubuntu containers. We did nothing.)
   • You find a security bug in library you use. How would you proceed?
   Same as above
   • What are techniques you always wanted to try and never had a chance to?
   Up to now I have used TDD (which I love). I want to try hexagonal architecture, microservices, complete CI/CD pipeline and REPL driven development
   • How many lines of code had systems you worked on in previous projects?
   Millions lines of Java code, thousands of Javascript, thousands of FORTRAN
   • Can you quickly describe architecture of the previous system you've worked on?
   Typical client server architecture where the main server monolith app was used as a gateway api for every external api call
   • If you wanted to help a younger and less experienced engineer to get better as fast as possible, how would you lead them?
   First of all, I would encourage them to ask questions. There are no silly questions.
   I would explain that there are only three layers in the pyramid of knowledge
7. what we know
8. what we know that we do not know
9. what we do not know that we do not know
   a senior engineer knows well the tools that uses every day and has a broad scope of the available tools that exists. If there is a need, they know what they should learn next.
   as a junior engineer, to advance further quickly, should grasp the foundations of the tools (language, runtime, even editor), a pet project would be ideal for this. Reading some books would not hurt either. Designing data-intensive applications from Kleppmann is a must read in my opinion. The pragmatic programmer too.
   Last but not least I would tell them to not be discouraged nor to compare themselves to others, only to their yesterday self.
   • Can you provide reference to your previous companies?
   https://www.linkedin.com/in/raphael-magkos-9b36b1128/ Raphael was the senior engineer of the last team at Interamerican. We both worked there as contractors.
   https://www.linkedin.com/in/sofia-samara-7ab1ba122/ Sofia was the developer I worked most with at Interamerican.
