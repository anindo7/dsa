## Super Ugly Number
A super ugly number is a positive integer whose prime factors are in the array primes.

Given an integer n and an array of integers primes, return the nth super ugly number.

The nth super ugly number is guaranteed to fit in a 32-bit signed integer.


### Example 1:

> Input: n = 12, primes = [2,7,13,19]
>
> Output: 32

### Example 2:

> Input: n = 1, primes = [2,3,5]
>
> Output: 1


### Constraints:

- 1 <= n <= 105
- 1 <= primes.length <= 100
- 2 <= primes[i] <= 1000
- primes[i] is guaranteed to be a prime number.
- All the values of primes are unique and sorted in ascending order.