---
title: "Recursion 2"
subtitle: "Recursion"
format:
  revealjs:
    theme: simple
    slide-number: true
    embed-resources: true 
    scrollable: true
---

### River Run Programming Contest: Extra Credit Opportunity (1 pt to course)

**What it is**
A 75-minute team coding contest on Codeforces. Teams of 2–3 share one laptop. Open to all SMCM students; no contest experience needed. Cash prizes up to $100.

**When (Round 1, attend one session)**

 - Wed, Oct 28, 4:30–6:00 PM, Schaefer Hall 165
 - Fri, Oct 30, 3:00–4:30 PM, Schaefer Hall 165

Top teams advance to the Round 2 final (date TBD).

**Deadline**

Register by **Sun, Oct 25, 11:59 PM**

**How to join**

 1. Every member creates a free Codeforces account. One member creates the team and invites the others.
 2. Everyone joins the [River Run Codeforces group](https://codeforces.com/group/C6MP3xZ6Ju/contests) as a **Participant** (not Spectator).
 3. One member registers the team on the [Google Form](https://forms.gle/jKcU7swEjNGSVRrQ7) using their SMCM login.

**Links**

 - Register: https://forms.gle/jKcU7swEjNGSVRrQ7
 - Codeforces group: https://codeforces.com/group/C6MP3xZ6Ju/contests
 - Questions: wsaleem@smcm.edu (put "River Run" in the subject line)



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


## What runs last?

| `return ...` | Order Java runs it | Last operation |
|---|---|---|---|
| `binarySearch(A, key, m + 1, R)` | 1. `m + 1` → 2. **call** `binarySearch` | **call** |
| `n * factorial(n - 1)` | 1. `n - 1` → 2. call `factorial` → 3. **multiply** `n × result` | **×** |
| `fib(n - 1) + fib(n - 2)` | 1. call `fib(n - 1)` → 2. call `fib(n - 2)` → 3. **add** | **+** |
| `factorialAcc(n - 1, acc * n)` | 1. `n - 1`, `acc * n` → 2. **call** `factorialAcc` | **call** |


## Converting recursion to iteration

A method is **tail recursive** if each activation makes **at most one** recursive call,
and **returns immediately** after that call (no further calculation on its result).

Example: sputnik countdown

```
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
```

After Refactoring:

```
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
```


## What runs last?

| `return ...` | Order Java runs it | Last operation | Tail recursive? |
|---|---|---|---|
| `binarySearch(A, key, m + 1, R)` | 1. `m + 1` → 2. **call** `binarySearch` | **call** | ✅ |
| `n * factorial(n - 1)` | 1. `n - 1` → 2. call `factorial` → 3. **multiply** `n × result` | **×** | ❌ |
| `fib(n - 1) + fib(n - 2)` | 1. call `fib(n - 1)` → 2. call `fib(n - 2)` → 3. **add** | **+** | ❌ |
| `factorialAcc(n - 1, acc * n)` | 1. `n - 1`, `acc * n` → 2. **call** `factorialAcc` | **call** | ✅ |

**Tail recursive:** the call is the **last** operation.
**Not tail recursive:** something (×, +, …) still has to happen **after** the call returns.

## What if it's not tail recursive?

```java
public static long factorial(int n) {
    if (n == 0) {
        return 1;
    }
    return n * factorial(n - 1);    // multiply is still waiting
}
```

The multiply happens **after** the call returns, so the recipe doesn't work directly.

**Fix:** do the pending work **before** the call, and carry the partial answer along in an extra parameter, called an **accumulator**.

## Adding an accumulator

1. Add a parameter `acc` that holds the **partial answer** so far.
2. The **base case** returns `acc` (the answer is already built).
3. Move the **pending work** into the call: `n * factorial(n - 1)` becomes `factorialAcc(n - 1, acc * n)`.
4. The first call starts `acc` at the **old base case value** (here, 1).

```java
public static long factorial(int n) {
    return factorialAcc(n, 1);               // step 4: start acc at 1
}

public static long factorialAcc(int n, long acc) {   // step 1
    if (n == 0) {
        return acc;                          // step 2
    }
    return factorialAcc(n - 1, acc * n);     // step 3: tail recursive!
}
```

| Call | n | acc |
|---|---|---|
| factorialAcc(4, 1) | 4 | 1 |
| factorialAcc(3, 4) | 3 | 4 |
| factorialAcc(2, 12) | 2 | 12 |
| factorialAcc(1, 24) | 1 | 24 |
| factorialAcc(0, 24) | 0 | 24 → return 24 |

## Now apply the recipe

Same recipe as before, with one addition: the accumulator **starts** at the value from the first call and is **returned** after the loop.

1. The **parameters** (`n` and `acc`) become loop variables. `acc` starts at 1.
2. The **base case** becomes the loop's **exit condition**. After the loop, return `acc`.
3. The **recursive call** becomes **updating the variables**.

:::: {.columns}
::: {.column width="48%"}
**Tail recursive**

```java
long factorialAcc(int n, long acc) {
    if (n == 0) {
        return acc;
    }
    return factorialAcc(n - 1, acc * n);
}
```
:::
::: {.column width="4%"}
:::
::: {.column width="48%"}
**Iterative**

```java
long factorial(int n) {
    long acc = 1;
    while (n > 0) {
        acc = acc * n;
        n = n - 1;
    }
    return acc;
}
```
:::
::::

## Activity: Climbing Stairs as a loop

```java
return ways(n - 1) + ways(n - 2);
```

Two recursive calls, so it's **not** tail recursive, and the accumulator trick doesn't apply.

**New idea:** instead of working **down** from `n`, build the answers **up** from the bottom.
Each answer only needs the **last two**, so keep two variables and update them.

| stairs | 0 | 1 | 2 | 3 | 4 | 5 |
|---|---|---|---|---|---|---|
| ways | 1 | 1 | 2 | 3 | 5 | 8 |

(0 stairs: 1 way, do nothing.)

Write `ways(n)` with a loop.

::: {.callout-tip collapse="true"}
## Answer

```java
public static int ways(int n) {
    int a = 1;                         // ways(0)
    int b = 1;                         // ways(1)
    while (n > 0) {
        int next = a + b;
        a = b;
        b = next;
        n = n - 1;
    }
    return a;
}
```
:::

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


