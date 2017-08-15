Using xmlbeans' `RegularExpression` class, the pattern `"[a-zA-Z0-9.,:'+-/()? ]+"` will cause a StackOverflowError when the input sequence is long enough.
With a thread stack size of 1M, the error will happen somewhere between 5400 and 5500 characters.

This is a known bug in xmlbeans: https://issues.apache.org/jira/browse/XMLBEANS-495
