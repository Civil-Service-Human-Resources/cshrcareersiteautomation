Feature: Login

    Scenario Outline: Successful login
        Given I am on the career site login page
        When I login as <role> with username <username> and password <password>
        Then I am successfully logged in as <username>
        Then I should see navitems <navmainheading>
        Examples:
        |role               |username           |password                |navmainheading             |
        |techadmin          |techadmin          |W^E4n9uoFGDvMcX@xz      |Dashboard,Media,Pages,Workflows,Appearance,Plugins,Users,Tools,Settings,Custom Fields|
        |contentadmin       |ContentAdmin1      |19Q4RjFXBNFczTd9k0mkZFzM|Dashboard,Media,Pages,Workflows,Users,Snippets|
        |contentApprover    |ContentApprover1   |Op$Eo$vJZZgggoJW!e6f%S4V|Dashboard,Media,Pages,Workflows,Profile|
        |ContentAuthor      |ContentAuthor1     |*dr%moW73FJXE1l20jbJw*p1|Dashboard,Media,Pages,Workflows,Profile|
        |ContentPublisher   |ContentPublisher1  |VmN0ZgqpNCkP!n0Xfrz$w$Cg|Dashboard,Media,Pages,Workflows,Profile|
        |ContentSnippets    |ContentSnippets1   |Cj92zbI4nVLFsmWvC85aR1Uy|Dashboard,Workflows,Profile,Snippets|

    Scenario Outline: Incorrect credentials
        Given I am on the career site login page
        When I try to login with incorrect <credential> username as <username> and password as <password>
        Then I am shown error message <errormessage>
        Examples:
        |credential    |username   |password      |errormessage          |
        |username       |test       |xyz          |Invalid username      |
        |password       |techadmin  |xyz          |Lost your password?   |
