package com.example.pricingpal.model.modules

import com.example.pricingpal.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.FlowType
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage
import javax.inject.Singleton

/**
 * This file contains a Dagger Hilt module that provides instances of the
 * Supabase client and related components
 *
 * @author Abdoulie NJie
 */

@InstallIn(SingletonComponent::class)
@Module
object SupabaseModule {

    /**
     * This function provides a singleton instance of SupabaseClient that returns
     * an instance of a SupabaseClient that is created with the createSupabaseClient function
     * and configured with the Supabase URL and anonymous key obtained from the BuildConfig.
     *
     * It also installs the Postgrest plugin needed to access the Supabase database
     */

    // variables used to reference Supabase URL and anonymous key needed to run the app
    val supabaseUrl = BuildConfig.SUPABASE_URL
    val supabaseKey = BuildConfig.SUPABASE_ANON_KEY

    @Provides
    @Singleton
    fun provideSupabaseClient(): SupabaseClient {
        return createSupabaseClient(
           supabaseUrl,
           supabaseKey
        ) {
            install(Postgrest)
            install(Auth) {
                flowType = FlowType.PKCE
                scheme = "app"
                host = "supabase.com"
            }
            install(Storage)
        }
    }
    /**
     *
     * @param client is a reference to the previous created SupabaseClient
     * @return a singleton instance of Postgrest, which represents the Supabase database client.
     */
    @Provides
    @Singleton
    fun provideSupabaseDatabase(client: SupabaseClient): Postgrest {
        return client.postgrest
    }
    /**
     *
     * @param client is a reference to the previous created SupabaseClient
     * @return a singleton instance of Auth, which represents the authentication
     * client for Supabase obtained from the SupabaseClient.
     *
     */
    @Provides
    @Singleton
    fun provideSupabaseAuth(client: SupabaseClient): Auth {
        return client.auth
    }
    /**
     *
     * @param client is a reference to the previous created SupabaseClient
     * @return a singleton instance of Storage, which is the Supabase storage client
     * for handling file uploads and downloads obtained from the SupabaseClient
     *
     */
    @Provides
    @Singleton
    fun provideSupabaseStorage(client: SupabaseClient): Storage {
        return client.storage
    }
}



// There is nowhere else to go; face the king, or perish at his hands ~Abdoulie NJie