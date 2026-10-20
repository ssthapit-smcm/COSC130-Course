---
title: "Recursion 2"
subtitle: "Recursion"
format:
  html:
    toc: true
    number-sections: true
    code-copy: true
---



# Activity 1  from last class

[LeetCode 70: Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

**Can you find the recursive pattern?**



## Recursion

**Recursion** is when a method solves a problem by calling **itself** on a **smaller** version of the same problem.

**Base case(s)**

- Values of the input for which we make **no** recursive calls.
- There must be at least one base case.
- Every chain of recursive calls must eventually reach a base case.

**Recursive calls**

- Calls to the current method.
- Each recursive call must make **progress** toward a base case.

---




# Another Recursion

## Activity: Guessing game

1. Pair up with the TA.
2. One of you secretly picks a number from 1 to 10 and writes it down.
3. The other guesses the number.
4. Your partner can only say **"higher,"** **"lower,"** or **"correct."**
5. Count your guesses.

How fast is your strategy?

## Linear search in sorted input

| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
|---|---|---|---|---|---|---|---|---|----|

- Check each element one by one, from the first to the last.
- Stop when the key is found, or when you reach the end.
- Worst case: the key is last or missing, so we check **all n** elements.

**Can we do better?** What if we use the fact that the array is sorted?

## Binary search

1. If only one element is left, it is the key. Stop.
2. Find the middle element.
3. If key ≤ middle, binary search the left half (with middle).
4. Otherwise, binary search the right half.

- **Base case:** one element left.
- **Recursive case:** binary search half of the array.


---



[Visualize it:](https://coddy.tech/visualize/searching/binary-search)



## Trace

Key = 9

| index | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
|-------|---|---|---|---|---|---|---|---|---|---|
| data  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |

| low | high | mid | A[mid] | Next |
|-----|------|-----|--------|------|
| 0 | 9 | 4 | 5 | 9 > 5, search right |
| 5 | 9 | 7 | 8 | 9 > 8, search right |
| 8 | 9 | 8 | 9 | 9 ≤ 9, search left (with middle) |
| 8 | 8 | | | one element left: found! |

## Pseudocode

```
Algorithm binarySearch(A, T, L, R)
   Input  a sorted array A
          a target value T to look up
          the leftmost index L
          the rightmost index R
   Output the index of T in A, or -1 if T is not found

   if L > R then
      return -1
   m ← L + floor((R - L) / 2)
   if A[m] < T then
      return binarySearch(A, T, m + 1, R)
   else if A[m] > T then
      return binarySearch(A, T, L, m - 1)
   else
      return m
```

First call: `binarySearch(A, key, 0, length(A) - 1)`

## Binary search in Java

```java
/**
 * Searches the sorted array A for T using recursive binary search.
 *
 * @param A the sorted array to search
 * @param T the target value
 * @param L the leftmost index of the range being searched
 * @param R the rightmost index of the range being searched
 * @return the index of T in A, or -1 if T is not found
 */
public static int binarySearch(int[] A, int T, int L, int R) {
    if (L > R) {
        return -1;                                  // not found
    }
    int m = L + (R - L) / 2;
    if (A[m] < T) {
        return binarySearch(A, T, m + 1, R);        // search right half
    } else if (A[m] > T) {
        return binarySearch(A, T, L, m - 1);        // search left half
    } else {
        return m;                                   // found
    }
}
```


## Recursion: benefits vs. downsides


## Converting recursion to iteration

Tail recursion
(sputnik countdown)

public class CountDown {
	public void countDown(int n) {
		if(n == 0) return;

		System.out.println(n + "...");
		waitASecond();
		countDown(n-1);
	}

	public void waitASecond() {
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException ignore) {
		}
	}

	public static void main(String[] args) {
		CountDown c = new CountDown();
		c.countDown(10);
	}
}
				
After Refactoring:

public class CountDown {
	public void countDown(int n) {
		while(n > 0) {
			System.out.println(n + "...");
			waitASecond ();
			n -= 1;
		}

	}

	public void waitASecond() {
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException ignore) {
		}
	}

	public static void main(String[] args) {
		CountDown c = new CountDown();
		c.countDown(10);
	}
}

Accumulator
(factorial stairs example)

## Activity:

5^4^ = 5 × 5 × 5 × 5 = 625

Notice that 5^4^ = 5 × **5^3^**.

- What is the base case?
- What is the recursive case?
- Write `power(x, n)` recursively.

::: {.callout-tip collapse="true"}
## Answer

```
power(x, n):
    if n == 0:
        return 1
    else:
        return x * power(x, n - 1)
```
:::

## Challenge: Can you make it faster?

5^17^ = 5 × 5 × 5 × 5 × 5 × 5 × 5 × 5 × 5 × 5 × 5 × 5 × 5 × 5 × 5 × 5 × 5

How many multiplications?

# Activity 1

**LeetCode 50: Pow(x, n):** <https://leetcode.com/problems/powx-n/description/>

Hint: 5^16^ = 5^8^ × 5^8^

- If you already know 5^8^, do you need to compute it twice?
- How many multiplications does 5^17^ need now?



# Activity 2

[LeetCode 1137. N-th Tribonacci Number](https://leetcode.com/problems/n-th-tribonacci-number/)


**Can you find the recursive pattern?**


