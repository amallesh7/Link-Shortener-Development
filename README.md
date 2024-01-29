### Documentation: LinkShortener

#### Design:

1. **LinkShortener Class:**
   - Manages a basic URL shortening service with bidirectional mappings using `shortToLongMap` and `longToShortMap` HashMaps.

2. **generateShortUrl Method:**
   - Implements a basic hash function to generate short URLs.
   - Converts the hash code of the long URL to a hexadecimal string and uses the first 6 characters as the short URL.

3. **shortenUrl Method:**
   - Generates a short URL for a given long URL, handling collisions by regenerating short URLs until a unique one is found.
   - Updates both mapping HashMaps.

4. **expandUrl Method:**
   - Expands a short URL to its original long form.
   - Uses `getOrDefault` to handle cases where the short URL is not in the mapping.

5. **Command-Line Interface (main Method):**
   - Presents an interactive menu for user-friendly interaction.
   - Allows users to choose between shortening, expanding, or exiting the program.

#### Features:

1. **URL Shortening:**
   - Users can input a long URL, and the program generates a corresponding short URL.
   - Collision handling ensures the uniqueness of short URLs.

2. **URL Expansion:**
   - Users can input a short URL, and the program retrieves the original long URL.
   - Provides feedback if the short URL is not found.

3. **Command-Line Interface:**
   - Real-time interaction with users through a menu-driven interface.
   - Immediate display of results.

#### Challenges Encountered:

1. **Collision Handling:**
   - Designing a strategy to handle collisions and regenerate short URLs for uniqueness.

2. **Hash Function Limitations:**
   - Dependency on the `hashCode` method for hashing may lead to collisions and impact uniqueness.

3. **Thread Safety:**
   - Lack of thread safety could result in concurrent modification issues in a multi-threaded environment.

4. **Input Validation:**
   - Ensuring proper validation of user inputs to handle potential errors and edge cases.

#### Conclusion:

The LinkShortener class provides a simple yet functional implementation of a URL shortening service with a command-line interface. It successfully addresses basic use cases of shortening and expanding URLs while handling collisions through short URL regeneration.

The design is straightforward and user-friendly, making it accessible for quick interactions. Future improvements could involve enhancing the hash function, ensuring thread safety, and implementing additional features for a more comprehensive URL shortening solution.
