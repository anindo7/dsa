## Sum of Compatible Numbers in Range I
You are given two integers n and k.
A positive integer x is called compatible if it satisfies both of the following conditions:

abs(n - x) <= k
(n & x) == 0
Return the sum of all compatible integers x.

Note:

Here, & denotes the bitwise AND operator.
The absolute difference between integers i and j is defined as abs(i - j).


### Example 1:

> Input: n = 2, k = 3
>
> Output: 10

### Example 2:

> Input: n = 5, k = 1
>
> Output: 0


### Constraints:

- 1 <= n <= 100
- 1 <= k <= 100