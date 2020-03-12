$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/com/test/CucumberProject/Math.feature");
formatter.feature({
  "name": "Maths operations",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@sanity"
    },
    {
      "name": "@dataproviders"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Add two numbers",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@add"
    }
  ]
});
formatter.step({
  "name": "I have number \u003ca\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "I have number \u003cb\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I click on add button",
  "keyword": "When "
});
formatter.step({
  "name": "User selects age category",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Age"
      ]
    },
    {
      "cells": [
        "below 18"
      ]
    },
    {
      "cells": [
        "Above 18"
      ]
    }
  ]
});
formatter.step({
  "name": "User selects state and country",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "State",
        "Country"
      ]
    },
    {
      "cells": [
        "KA",
        "India"
      ]
    },
    {
      "cells": [
        "AZ",
        "US"
      ]
    }
  ]
});
formatter.step({
  "name": "I get result",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "a",
        "b"
      ]
    },
    {
      "cells": [
        "2",
        "3"
      ]
    },
    {
      "cells": [
        "5",
        "5"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Add two numbers",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@sanity"
    },
    {
      "name": "@dataproviders"
    },
    {
      "name": "@add"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have number 2",
  "keyword": "Given "
});
formatter.match({
  "location": "MathsStepsDef.num1(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have number 3",
  "keyword": "And "
});
formatter.match({
  "location": "MathsStepsDef.num1(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on add button",
  "keyword": "When "
});
formatter.match({
  "location": "MathsStepsDef.add()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User selects age category",
  "rows": [
    {
      "cells": [
        "Age"
      ]
    },
    {
      "cells": [
        "below 18"
      ]
    },
    {
      "cells": [
        "Above 18"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "MathsStepsDef.selectAge(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User selects state and country",
  "rows": [
    {
      "cells": [
        "State",
        "Country"
      ]
    },
    {
      "cells": [
        "KA",
        "India"
      ]
    },
    {
      "cells": [
        "AZ",
        "US"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "MathsStepsDef.selectStateAndCountry(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get result",
  "keyword": "And "
});
formatter.match({
  "location": "MathsStepsDef.result()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Add two numbers",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@sanity"
    },
    {
      "name": "@dataproviders"
    },
    {
      "name": "@add"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have number 5",
  "keyword": "Given "
});
formatter.match({
  "location": "MathsStepsDef.num1(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have number 5",
  "keyword": "And "
});
formatter.match({
  "location": "MathsStepsDef.num1(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on add button",
  "keyword": "When "
});
formatter.match({
  "location": "MathsStepsDef.add()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User selects age category",
  "rows": [
    {
      "cells": [
        "Age"
      ]
    },
    {
      "cells": [
        "below 18"
      ]
    },
    {
      "cells": [
        "Above 18"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "MathsStepsDef.selectAge(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User selects state and country",
  "rows": [
    {
      "cells": [
        "State",
        "Country"
      ]
    },
    {
      "cells": [
        "KA",
        "India"
      ]
    },
    {
      "cells": [
        "AZ",
        "US"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "MathsStepsDef.selectStateAndCountry(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get result",
  "keyword": "And "
});
formatter.match({
  "location": "MathsStepsDef.result()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});