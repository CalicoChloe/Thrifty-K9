package com.example.pricingpal.model

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

/**
 * Class: Database
 * @author Chloe Jackson
 * @version 1
 * @written 11/01/2023
 * This object class holds functions to handle database connections.
 */
object Database {
    /**
     * getClient
     * This function creates a SupabaseClient object to be used for database connections.
     * @return SupabaseClient The SupabaseClient object created by the function
     */
    fun getClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://vpyawdponrgobslbwabo.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZweWF3ZHBvbnJnb2JzbGJ3YWJvIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTgxOTM5MTYsImV4cCI6MjAxMzc2OTkxNn0.T3GTufeu73alM9qi-Q8U4znBUwACZYwO_Fnh0xT8Zf0",
        ) {
            install(Postgrest)
        }
    }
}